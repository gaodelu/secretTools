package com.mochi.secret;

import com.mochi.common.enumutil.ResponseEnum;
import com.mochi.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

/**
 * DES加解密工具
 */
public class AesUtil {
    private static final String ALGORITHM = "AES";

    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
    private static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";

    private static SecretKeySpec initKey(String hexKey) throws NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        if (hexKey.length() == 16) {
            return new SecretKeySpec(hexKey.getBytes(), ALGORITHM);
        }
        if (hexKey.length() == 24) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = new SecureRandom(hexKey.getBytes());
            keyGenerator.init(192, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();
            return new SecretKeySpec(keyBytes, ALGORITHM);
        }
        if (hexKey.length() == 32) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = new SecureRandom(hexKey.getBytes());
            keyGenerator.init(256, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();
            return new SecretKeySpec(keyBytes, ALGORITHM);
        }
        throw new BusinessException(ResponseEnum.PB_0006.getRespCode(), ResponseEnum.PB_0006.getRespMsg());
    }


    public static String encrypt(String keyHex, String data, String iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (keyHex == null || keyHex.length() < 8) {
            throw new BusinessException(ResponseEnum.PB_0004.getRespCode(), ResponseEnum.PB_0004.getRespMsg());
        }
        if (StringUtils.isBlank(data)) {
            throw new BusinessException(ResponseEnum.PB_0002.getRespCode(), ResponseEnum.PB_0002.getRespMsg());
        }
        Key secretKey = initKey(keyHex);
        Cipher cipher;
        if (!StringUtils.isBlank(iv)) {
            IvParameterSpec ivSpec = new IvParameterSpec(Hex.decode(iv));
            cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        } else {
            cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        }
        byte[] bytes = cipher.doFinal(Hex.decode(data));
        return Hex.toHexString(bytes).toUpperCase();
    }

    /**
     * AES解密
     *
     * @param keyHex
     * @param srcData
     * @return
     */
    public static String decrypt(String keyHex, String srcData, String iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (keyHex == null || keyHex.length() < 8) {
            throw new BusinessException(ResponseEnum.PB_0004.getRespCode(), ResponseEnum.PB_0004.getRespMsg());
        }
        if (StringUtils.isBlank(srcData)) {
            throw new BusinessException(ResponseEnum.PB_0002.getRespCode(), ResponseEnum.PB_0002.getRespMsg());
        }

        Key secretKey = initKey(keyHex);
        Cipher cipher;
        if (!StringUtils.isBlank(iv)) {
            IvParameterSpec ivSpec = new IvParameterSpec(Hex.decode(iv));
            cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        } else {
            cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
        }
        byte[] bytes = cipher.doFinal(Hex.decode(srcData));
        return Hex.toHexString(bytes).toUpperCase();
    }

}

