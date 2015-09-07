package com.datmedia.mediaplayer.androidrequestresponse;

import android.util.Log;

import com.datmedia.mediaplayer.messages.MessageOuterClass;
import com.google.protobuf.InvalidProtocolBufferException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import eneter.messaging.dataprocessing.serializing.ISerializer;
import eneter.messaging.endpoints.typedmessages.DuplexTypedMessagesFactory;
import eneter.messaging.endpoints.typedmessages.IDuplexTypedMessageSender;
import eneter.messaging.endpoints.typedmessages.IDuplexTypedMessagesFactory;
import eneter.messaging.endpoints.typedmessages.TypedResponseReceivedEventArgs;
import eneter.messaging.messagingsystems.messagingsystembase.IDuplexOutputChannel;
import eneter.messaging.messagingsystems.messagingsystembase.IMessagingSystemFactory;
import eneter.messaging.messagingsystems.websocketmessagingsystem.WebSocketMessagingSystemFactory;
import eneter.net.system.EventHandler;
import eneter.protobuf.ProtoBufSerializer;


public class ClientRequestDispatcher {

    final ILogUpdate mLogUpdate;
    final IEnrollmentResponse mEnrollmentResponse;

    public ClientRequestDispatcher(ILogUpdate logUpdate, IEnrollmentResponse enrollmentResponse){
        mLogUpdate = logUpdate;

        mEnrollmentResponse = enrollmentResponse;
        openConnection();
    }


    private IDuplexTypedMessageSender<MessageOuterClass.Message, MessageOuterClass.Message> mSender;

    private  void openConnection(){
        if(mSender == null){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ISerializer protoBufSerializer = new ProtoBufSerializer();

                    IDuplexTypedMessagesFactory senderFactory = new DuplexTypedMessagesFactory(protoBufSerializer);

                    mSender = senderFactory.createDuplexTypedMessageSender(MessageOuterClass.Message.class, MessageOuterClass.Message.class);
                    mSender.responseReceived().subscribe(mOnResponseHandler);

                    IMessagingSystemFactory messaging = new WebSocketMessagingSystemFactory();
                    try {
                        IDuplexOutputChannel outputChannel = messaging.createDuplexOutputChannel("ws://192.168.15.124:8091/MessagingSpikeServer/");
                        mSender.attachDuplexOutputChannel(outputChannel);
                    } catch (Exception e) {
                        mLogUpdate.logUpdated("Error", "mSender.attachDuplexOutputChannel", e.getMessage());
                    }
                }
            }).start();
        }
    }

    private EventHandler<TypedResponseReceivedEventArgs<MessageOuterClass.Message>> mOnResponseHandler = new EventHandler<TypedResponseReceivedEventArgs<MessageOuterClass.Message>>() {
        @Override
        public void onEvent(Object o, TypedResponseReceivedEventArgs<MessageOuterClass.Message> testResponseTypedResponseReceivedEventArgs) {
            try {
                onResponseReceived(o,testResponseTypedResponseReceivedEventArgs);
            } catch (BadPaddingException e) {
                mLogUpdate.logUpdated("Error","EventHandler.onResponseReceived", e.getMessage());
            } catch (NoSuchAlgorithmException e) {
                mLogUpdate.logUpdated("Error","EventHandler.onResponseReceived", e.getMessage());
            } catch (InvalidProtocolBufferException e) {
                mLogUpdate.logUpdated("Error", "EventHandler.onResponseReceived",e.getMessage());
            } catch (IllegalBlockSizeException e) {
                mLogUpdate.logUpdated("Error","EventHandler.onResponseReceived", e.getMessage());
            } catch (NoSuchPaddingException e) {
                mLogUpdate.logUpdated("Error","EventHandler.onResponseReceived", e.getMessage());
            } catch (InvalidKeyException e) {
                mLogUpdate.logUpdated("Error", "EventHandler.onResponseReceived",e.getMessage());
            } catch (InvalidKeySpecException e) {
                mLogUpdate.logUpdated("Error", "EventHandler.onResponseReceived",e.getMessage());
            } catch (Exception e) {
                mLogUpdate.logUpdated("Error","EventHandler.onResponseReceived", e.getMessage());
            }
        }
    };

    private void onResponseReceived(Object sender, final TypedResponseReceivedEventArgs<MessageOuterClass.Message> e) throws Exception {
        mLogUpdate.logUpdated("Debug","onResponseReceived", "Message is received");

        if(e.getReceivingError() != null){
            mLogUpdate.logUpdated("Error", "onResponseReceived", "Received message error: " + e.getReceivingError().getMessage());
        }else{
            final MessageOuterClass.Message response = e.getResponseMessage();

            if(response.getMessageType() == MessageOuterClass.MessageType.EnrollmentResponse){
                mEnrollmentResponse.enrollmentResponse(response);
            }
        }
    }

    public void sendMessage(MessageOuterClass.Message message) throws Exception {
        mSender.sendRequestMessage(message);
    }
}
