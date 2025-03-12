package com.qzx.utils;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

public class WeChatDecryptor {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * Decrypts the encrypted data using the provided session key and iv.
     *
     * @param encryptedData The base64-encoded encrypted data.
     * @param iv            The base64-encoded initialization vector.
     * @param sessionKey    The base64-encoded session key.
     * @return The decrypted phone number.
     * @throws Exception If an error occurs during decryption.
     */
    public static String decryptPhoneNumber(String encryptedData, String iv, String sessionKey){
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] keyBytes = Base64.getDecoder().decode(sessionKey);
            byte[] ivBytes = Base64.getDecoder().decode(iv);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivBytes);

            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // Convert the decrypted bytes to a JSON string
            String decryptedString = new String(decryptedBytes, "UTF-8");

            // Parse the JSON string to extract the phone number
            int startIndex = decryptedString.indexOf("\"phoneNumber\":\"") + "\"phoneNumber\":\"".length();
            int endIndex = decryptedString.indexOf("\"", startIndex);
            return decryptedString.substring(startIndex, endIndex);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | BadPaddingException |
                 NoSuchProviderException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }
}