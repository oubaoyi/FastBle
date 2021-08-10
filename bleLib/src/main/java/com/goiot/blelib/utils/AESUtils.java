package com.goiot.blelib.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
    // 加密
    public static byte[] Encrypt(byte[] sSrc, String sKey, String IV) {
        try {
            byte[] raw = new byte[0];
            raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            /**
             * 这个地方调用BouncyCastleProvider
             *让java支持PKCS7Padding
             */
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            //"算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ips);
            byte[] encrypted = cipher.doFinal(sSrc);
            return encrypted;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 解密
    public static byte[] Decrypt(byte[] sSrc, String sKey, String IV) {
        try {
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            /**
             * 这个地方调用BouncyCastleProvider
             *让java支持PKCS7Padding
             */
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            IvParameterSpec ips = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ips);
            byte[] encrypted1 = sSrc;
            try {
                byte[] original = cipher.doFinal(encrypted1);
                return original;
            } catch (Exception e) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }


    public static String EncryptToBase64(String sSrc, String sKey, String IV){
        return Base64Encoder.encode(Encrypt(sSrc.getBytes(StandardCharsets.UTF_8),sKey,IV));
    }

    public static String Base64ToDecrypt(String sSrc, String sKey, String IV){
        String s=new String(Decrypt(Base64Decoder.decodeToBytes(sSrc),sKey,IV),StandardCharsets.UTF_8);
        return s;
    }

    public static String EncryptToHex(String sSrc, String sKey, String IV){
        return HexUtil.formatHexString(Encrypt(sSrc.getBytes(StandardCharsets.UTF_8),sKey,IV));
    }

    public static String HexToDecrypt(String sSrc, String sKey, String IV){
        String s=new String(Decrypt(HexUtil.hexStringToBytes(sSrc),sKey,IV),StandardCharsets.UTF_8);
        return s;
    }

//    public static void main(String[] args) throws Exception {
//
//        String cKey = "0123456789abcdef";
//
//        // 需要加密的字串
//        String cSrc = "001ADC0000700AC40055001AABBCCDDEEFF1234888888888888888820201204120005";
//        System.out.println(cKey);
//        // 加密
//        String enString = AESUtils.EncryptToBase64(cSrc, cKey, cKey);
//        System.out.println("加密后的Base64是：" + enString);
//
//        // 解密
//        String DeString = AESUtils.Base64ToDecrypt(enString, cKey, cKey);
//        System.out.println("解密后的字符串是：" + DeString);
//
//
//        // 加密
//        String enString1 = AESUtils.EncryptToHex(cSrc, cKey, cKey);
//        System.out.println("加密后的HEX是：" + enString1);
//
//        // 解密
//        String DeString1 = AESUtils.HexToDecrypt(enString1, cKey, cKey);
//        System.out.println("HEX解密后的字符串是：" + DeString1);
//    }
}