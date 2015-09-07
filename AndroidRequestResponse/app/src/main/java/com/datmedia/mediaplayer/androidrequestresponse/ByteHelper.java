package com.datmedia.mediaplayer.androidrequestresponse;


public class ByteHelper {
    public static byte[] removeLeadingZero(byte[] oldByte){
        int length = oldByte.length -1;

        byte[] newBytes = new byte[length];

        for(int i = 1; i < oldByte.length; i++){
            newBytes[i-1] = oldByte[i];
        }

        return newBytes;
    }
}
