package com.datmedia.mediaplayer.androidrequestresponse;

import com.datmedia.mediaplayer.messages.MessageOuterClass;
import com.google.protobuf.InvalidProtocolBufferException;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface IEnrollmentResponse {
    void enrollmentResponse(MessageOuterClass.Message message) throws Exception;
}
