package com.datmedia.mediaplayer.androidrequestresponse;

import android.util.Log;

import com.datmedia.mediaplayer.messages.MessageOuterClass;

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

    public ClientRequestDispatcher(ILogUpdate logUpdate){
        mLogUpdate = logUpdate;
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
                        IDuplexOutputChannel outputChannel = messaging.createDuplexOutputChannel("ws://192.168.15.124:8091/");
                        mSender.attachDuplexOutputChannel(outputChannel);
                    } catch (Exception e) {
                        mLogUpdate.logUpdated("Error", e.getMessage());
                    }
                }
            }).start();
        }
    }

    private EventHandler<TypedResponseReceivedEventArgs<MessageOuterClass.Message>> mOnResponseHandler = new EventHandler<TypedResponseReceivedEventArgs<MessageOuterClass.Message>>() {
        @Override
        public void onEvent(Object o, TypedResponseReceivedEventArgs<MessageOuterClass.Message> testResponseTypedResponseReceivedEventArgs) {
            onResponseReceived(o,testResponseTypedResponseReceivedEventArgs);

        }
    };

    private void onResponseReceived(Object sender, final TypedResponseReceivedEventArgs<MessageOuterClass.Message> e){
        mLogUpdate.logUpdated("Debug", "Message is received");

        if(e.getReceivingError() != null){
            mLogUpdate.logUpdated("Error", "Received message error: " + e.getReceivingError().getMessage());
        }else{
            final MessageOuterClass.Message response = e.getResponseMessage();

            if(response.getMessageType() == MessageOuterClass.MessageType.EnrollmentResponse){

            }
        }

    }
}
