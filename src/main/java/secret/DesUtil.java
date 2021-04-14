package secret;

import common.enumutil.ResponseEnum;
import common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

/**
 * DES加解密工具
 */
public class DesUtil {

    private static final String ALGORITHM = "DES";

    /**
     * 加密/解密算法-工作模式-填充模式
     */
    private static final String CIPHER_ALGORITHM_CBC = "DES/CBC/PKCS5Padding";
    private static final String CIPHER_ALGORITHM_ECB = "DES/ECB/PKCS5Padding";

    /**
     * DES-ECB加密
     *
     * @param keyHex
     * @param data
     * @return
     */
    public static String encrypt(String keyHex, String data, String iv) {
        if (keyHex == null || keyHex.length() < 8) {
            throw new BusinessException(ResponseEnum.PB_0004.getRespCode(), ResponseEnum.PB_0004.getRespMsg());
        }
        if (StringUtils.isBlank(data)) {
            throw new BusinessException(ResponseEnum.PB_0002.getRespCode(), ResponseEnum.PB_0002.getRespMsg());
        }
        try {
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
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.PB_0003.getRespCode(), e.getMessage());
        }
    }


    /**
     * DES-ECB加密
     *
     * @param keyHex
     * @param srcData
     * @return
     */
    public static String decrypt(String keyHex, String srcData, String iv) {
        if (keyHex == null || keyHex.length() < 8) {
            throw new BusinessException(ResponseEnum.PB_0004.getRespCode(), ResponseEnum.PB_0004.getRespMsg());
        }
        if (StringUtils.isBlank(srcData)) {
            throw new BusinessException(ResponseEnum.PB_0002.getRespCode(), ResponseEnum.PB_0002.getRespMsg());
        }
        try {
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
        } catch (Exception e) {
            throw new BusinessException(ResponseEnum.PB_0005.getRespCode(), e.getMessage());
        }
    }


    private static Key initKey(String keyHex) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException {
        Security.addProvider(new BouncyCastleProvider());
        DESKeySpec dks = new DESKeySpec(Hex.decode(keyHex));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        return keyFactory.generateSecret(dks);
    }
}
