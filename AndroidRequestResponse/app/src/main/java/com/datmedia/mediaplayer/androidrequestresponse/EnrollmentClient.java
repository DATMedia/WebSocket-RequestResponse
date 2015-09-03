package com.datmedia.mediaplayer.androidrequestresponse;

import com.datmedia.mediaplayer.messages.Enrollment.ConfirmationReceiptOuterClass;
import com.datmedia.mediaplayer.messages.Enrollment.EnrollmentConfirmationOuterClass;
import com.datmedia.mediaplayer.messages.Enrollment.InitialResponseOuterClass;
import com.datmedia.mediaplayer.messages.Enrollment.PublicKeyOuterClass;
import com.datmedia.mediaplayer.messages.Enrollment.RequestContentsOuterClass;
import com.datmedia.mediaplayer.messages.Enrollment.ResponseContentsOuterClass;
import com.datmedia.mediaplayer.messages.MessageOuterClass;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class EnrollmentClient {
    final ClientCryptoServiceProvider mClientCryptoServiceProvider;
    final IEnrollmentRequestCodeReceived mEnrollmentRequestCodeReceived;
    final ILogUpdate mLogUpdate;
    final IEnrollmentCompleted mEnrollmentCompleted;
    final ISendMessage mSendMessage;

    public  EnrollmentClient(ClientCryptoServiceProvider clientCryptoServiceProvider, IEnrollmentRequestCodeReceived enrollmentRequestCodeReceived, ILogUpdate logUpdate, IEnrollmentCompleted enrollmentCompleted, ISendMessage sendMessage){
        mSendMessage = sendMessage;
        mClientCryptoServiceProvider = clientCryptoServiceProvider;
        mEnrollmentRequestCodeReceived = enrollmentRequestCodeReceived;
        mLogUpdate = logUpdate;
        mEnrollmentCompleted = enrollmentCompleted;
    }


    public void beginEnrollment(){

    }

    public void handleEnrollmentResponse(byte[] enrollmentResponseContentsSerialized) throws InvalidProtocolBufferException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException {
        ResponseContentsOuterClass.ResponseContents contents = ResponseContentsOuterClass.ResponseContents.parseFrom(enrollmentResponseContentsSerialized);

        if(contents != null){
            if(contents.getResponseType() == ResponseContentsOuterClass.ResponseType.InitialResponse){
                handleInitialResponse(contents.getData());
            }else{
                handleEnrollmentConfirmation(contents.getData());
            }
        }
    }

    private void handleEnrollmentConfirmation(ByteString data) throws InvalidProtocolBufferException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        EnrollmentConfirmationOuterClass.EnrollmentConfirmation enrollmentConfirmation = EnrollmentConfirmationOuterClass.EnrollmentConfirmation.parseFrom(data.toByteArray());
        mEnrollmentCompleted.enrollmentCompleted(enrollmentConfirmation.getDeviceId());

        byte[] decryptChallenge = mClientCryptoServiceProvider.DecryptUsingPrivateKey(enrollmentConfirmation.getEncryptedChallenge().toByteArray());

        byte[] encryptedResponse = mClientCryptoServiceProvider.EncryptUsingServerKey(decryptChallenge);

        ConfirmationReceiptOuterClass.ConfirmationReceipt confirmationReceipt = ConfirmationReceiptOuterClass.ConfirmationReceipt.newBuilder()
                                                                                                                                 .setChallengeResponse(ByteString.copyFrom(encryptedResponse))
                                                                                                                                 .build();

        RequestContentsOuterClass.RequestContents confirmation = RequestContentsOuterClass.RequestContents.newBuilder()
                                                                                                           .setRequestType(RequestContentsOuterClass.RequestType.ConfirmationReceipt)
                                                                                                           .setData(ByteString.copyFrom(confirmationReceipt.toByteArray()))
                                                                                                           .build();

       mSendMessage.sendMessage(MessageOuterClass.Message.newBuilder()
                                                         .setMessageContents(ByteString.copyFrom(confirmation.toByteArray()))
                                                          .setMessageType(MessageOuterClass.MessageType.EnrollmentRequest)
                                                          .build());
    }


    private void handleInitialResponse(ByteString data) throws InvalidProtocolBufferException, InvalidKeySpecException {
        InitialResponseOuterClass.InitialResponse initialResponse = InitialResponseOuterClass.InitialResponse.parseFrom(data.toByteArray());

        PublicKeyOuterClass.PublicKey publicKey = PublicKeyOuterClass.PublicKey.parseFrom(initialResponse.getServerPublicKey().toByteArray());

        mClientCryptoServiceProvider.setServerPublicKey(publicKey);
        mEnrollmentRequestCodeReceived.EnrollmentRequestCodeReceived(initialResponse.getUniqueEnrollmentCode());
    }
}
