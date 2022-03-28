package secret;

import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;

public class SM4Util {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static final String ALGORITHM_NAME = "SM4";
    // 加密算法/分组加密模式/分组填充方式
    // PKCS5Padding-以8个字节为一组进行分组加密
    // 定义分组加密模式使用：PKCS5Padding
    public static final String ALGORITHM_NAME_ECB_PADDING = "SM4/ECB/PKCS5Padding";
    // 定义分组加密模式使用：PKCS5Padding
    public static final String ALGORITHM_NAME_CBC_PADDING = "SM4/CBC/PKCS5Padding";
    // 128-32位16进制；256-64位16进制
    public static final int DEFAULT_KEY_SIZE = 128;

    /**
     * 自动生成密钥
     *
     * @return
     * @explain
     */
    public static String generateKey() throws Exception {
        return new String(Hex.encode(generateKey(DEFAULT_KEY_SIZE))).toUpperCase();
    }

    /**
     * @param keySize
     * @return
     * @throws Exception
     * @explain
     */
    public static byte[] generateKey(int keySize) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM_NAME, BouncyCastleProvider.PROVIDER_NAME);
        kg.init(keySize, new SecureRandom());
        return kg.generateKey().getEncoded();
    }


    /**
     * sm4加密
     *
     * @param hexKey   16进制密钥（忽略大小写）
     * @param paramStr 待加密字符串
     * @return 返回16进制的加密字符串
     * @explain 加密模式：ECB
     * 密文长度不固定，会随着被加密字符串长度的变化而变化
     */
    public static String encryptEcb(String hexKey, String paramStr,String iv) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, InvalidKeyException, InvalidAlgorithmParameterException {
        String cipherText = "";
        // 16进制字符串--&gt;byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // String--&gt;byte[]
        byte[] srcData = Hex.decode(paramStr);
        Cipher cipher;
        if (!StringUtils.isBlank(iv)) {
            IvParameterSpec ivSpec = new IvParameterSpec(Hex.decode(iv));
            cipher = Cipher.getInstance(ALGORITHM_NAME_CBC_PADDING);
            Key sm4Key = new SecretKeySpec(keyData, ALGORITHM_NAME);
            cipher.init(Cipher.ENCRYPT_MODE, sm4Key, ivSpec);
        } else {
            cipher = Cipher.getInstance(ALGORITHM_NAME_ECB_PADDING);
            Key sm4Key = new SecretKeySpec(keyData, ALGORITHM_NAME);
              cipher.init(Cipher.ENCRYPT_MODE, sm4Key);
        }
        // 加密后的数组
        byte[] cipherArray = cipher.doFinal(srcData);
        cipherText = ByteUtils.toHexString(cipherArray);
        return cipherText;
    }


    private static Cipher generateEcbCipher(String algorithmName, int mode, byte[] key) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance(algorithmName, BouncyCastleProvider.PROVIDER_NAME);
        Key sm4Key = new SecretKeySpec(key, ALGORITHM_NAME);
        cipher.init(mode, sm4Key);
        return cipher;
    }


    /**
     * 加密模式之Ecb
     *
     * @param key
     * @param data
     * @return
     * @throws Exception
     * @explain
     */
    public static byte[] encrypt_Ecb_Padding(byte[] key, byte[] data) throws NoSuchProviderException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    /**
     * sm4解密
     *
     * @param hexKey     16进制密钥
     * @param cipherText 16进制的加密字符串（忽略大小写）
     * @param iv
     * @return 解密后的字符串
     * @throws Exception
     * @explain 解密模式：采用ECB
     */
    public static String decryptEcb(String hexKey, String cipherText, String iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // 16进制字符串--&gt;byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // String--&gt;byte[]
        byte[] srcData = Hex.decode(cipherText);
        Cipher cipher;
        if (!StringUtils.isBlank(iv)) {
            IvParameterSpec ivSpec = new IvParameterSpec(Hex.decode(iv));
            cipher = Cipher.getInstance(ALGORITHM_NAME_CBC_PADDING);
            Key sm4Key = new SecretKeySpec(keyData, ALGORITHM_NAME);
            cipher.init(Cipher.DECRYPT_MODE, sm4Key, ivSpec);
        } else {
            cipher = Cipher.getInstance(ALGORITHM_NAME_ECB_PADDING);
            Key sm4Key = new SecretKeySpec(keyData, ALGORITHM_NAME);
            cipher.init(Cipher.DECRYPT_MODE, sm4Key);
        }
        // 加密后的数组
        byte[] cipherArray = cipher.doFinal(srcData);
        cipherText = ByteUtils.toHexString(cipherArray);
        return cipherText;
    }

    /**
     * 解密
     *
     * @param key
     * @param cipherText
     * @return
     * @throws Exception
     * @explain
     */
    public static byte[] decrypt_Ecb_Padding(byte[] key, byte[] cipherText) throws Exception {
        Cipher cipher = generateEcbCipher(ALGORITHM_NAME_ECB_PADDING, Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(cipherText);
    }

    /**
     * 校验加密前后的字符串是否为同一数据
     *
     * @param hexKey     16进制密钥（忽略大小写）
     * @param cipherText 16进制加密后的字符串
     * @param paramStr   加密前的字符串
     * @return 是否为同一数据
     * @throws Exception
     * @explain
     */
    public static boolean verifyEcb(String hexKey, String cipherText, String paramStr) throws Exception {
        // 用于接收校验结果
        boolean flag = false;
        // hexString--&gt;byte[]
        byte[] keyData = ByteUtils.fromHexString(hexKey);
        // 将16进制字符串转换成数组
        byte[] cipherData = ByteUtils.fromHexString(cipherText);
        // 解密
        byte[] decryptData = decrypt_Ecb_Padding(keyData, cipherData);
        // 将原字符串转换成byte[]
        byte[] srcData = paramStr.getBytes(StandardCharsets.UTF_8);
        // 判断2个数组是否一致
        flag = Arrays.equals(decryptData, srcData);
        return flag;
    }
}
