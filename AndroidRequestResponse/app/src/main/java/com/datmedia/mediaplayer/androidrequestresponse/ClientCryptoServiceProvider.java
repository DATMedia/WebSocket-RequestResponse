package com.datmedia.mediaplayer.androidrequestresponse;

import com.datmedia.mediaplayer.messages.Enrollment.PublicKeyOuterClass;
import com.google.protobuf.ByteString;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class ClientCryptoServiceProvider {
    private KeyPairGenerator mKeyPairGenerator;
    private KeyPair mKeyPair;
    private KeyFactory mFactory;
    private Cipher mCipherEncrypt;
    private Cipher mCipherDecrypt;
    private PublicKey mServerPublicKey;


    public ClientCryptoServiceProvider() throws NoSuchAlgorithmException, NoSuchPaddingException {
        mKeyPairGenerator = KeyPairGenerator.getInstance("RSA");
        mKeyPairGenerator.initialize(1024);
        mKeyPair = mKeyPairGenerator.genKeyPair();
        mFactory = KeyFactory.getInstance("RSA");
        mCipherEncrypt = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        mCipherDecrypt = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
    }

    public PublicKeyOuterClass.PublicKey getPublicKey() throws InvalidKeySpecException {
        RSAPublicKeySpec rsaPublicKey = mFactory.getKeySpec(mKeyPair.getPublic(), RSAPublicKeySpec.class);

        return PublicKeyOuterClass.PublicKey.newBuilder()
                                            .setExponent(ByteString.copyFrom(rsaPublicKey.getPublicExponent().toByteArray()))
                                             .setModules(ByteString.copyFrom(rsaPublicKey.getModulus().toByteArray()))
                                             .build();
    }

    public void setServerPublicKey(PublicKeyOuterClass.PublicKey publicKey) throws InvalidKeySpecException {
        BigInteger modulus = new BigInteger(1, publicKey.getModules().toByteArray());
        BigInteger exponent = new BigInteger(1, publicKey.getExponent().toByteArray());
        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
        mServerPublicKey = mFactory.generatePublic(rsaPublicKeySpec);
    }


    public byte[] EncryptUsingServerKey(final byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException,InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        mCipherEncrypt.init(Cipher.ENCRYPT_MODE, mServerPublicKey);
        return  mCipherEncrypt.doFinal(data);
    }

    public byte[] DecryptUsingPrivateKey(final byte[] encryptedBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        mCipherDecrypt.init(Cipher.DECRYPT_MODE, mKeyPair.getPrivate());
        return  mCipherDecrypt.doFinal(encryptedBytes);
    }

//    public byte[] convertCSharpRSAParameter(PublicKeyOuterClass.PublicKey publicKeyFromServer, byte[] data) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
//        BigInteger modulus = new BigInteger(1, publicKeyFromServer.getModules().toByteArray());
//        BigInteger exponent = new BigInteger(1, publicKeyFromServer.getExponent().toByteArray());
//
//        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, exponent);
//        KeyFactory factory = KeyFactory.getInstance("RSA");
//
//        PublicKey publicKey = factory.generatePublic(rsaPublicKeySpec);
//
//        factory.getKeySpec(publicKey, RSAPublicKeySpec.class);
//
//        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
//        cipher.init(Cipher.DECRYPT_MODE, publicKey);
//
//        return cipher.doFinal(data);
//
//    }


}
