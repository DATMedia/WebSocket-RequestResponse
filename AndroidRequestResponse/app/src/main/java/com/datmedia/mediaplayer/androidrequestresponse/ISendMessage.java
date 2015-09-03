package com.datmedia.mediaplayer.androidrequestresponse;

import com.datmedia.mediaplayer.messages.MessageOuterClass;

/**
 * Created by wchen on 3/09/2015.
 */
public interface ISendMessage {
    void sendMessage(MessageOuterClass.Message message);
}
