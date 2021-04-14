package secret;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;
import java.util.Arrays;

public class SM3Util {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * SM3加密
     *
     * @param paramStr
     * @return
     */
    public static String encrypt(String paramStr) {
        String resultHexString = "";
        byte[] srcData = paramStr.getBytes();
        SM3Digest digest = new SM3Digest();
        digest.update(srcData, 0, srcData.length);
        byte[] hash = new byte[digest.getDigestSize()];
        digest.doFinal(hash, 0);
        resultHexString = Hex.encodeHexString(hash);
        return resultHexString.toUpperCase();
    }

    /**
     * 带密钥的SM3加密
     *
     * @param key      密钥
     * @param paramStr 待加密字符串
     * @return
     */
    public static String hmac(String key, String paramStr) {
        paramStr = encrypt(paramStr);
        KeyParameter keyParameter = new KeyParameter(key.getBytes());
        SM3Digest digest = new SM3Digest();
        HMac mac = new HMac(digest);
        mac.init(keyParameter);
        mac.update(paramStr.getBytes(), 0, paramStr.getBytes().length);
        byte[] result = new byte[mac.getMacSize()];
        mac.doFinal(result, 0);

        return Hex.encodeHexString(result).toUpperCase();
    }

    public static boolean verify(String srcStr, String sm3HexString) {
        boolean flag = false;
        try {
            byte[] srcData = srcStr.getBytes();
            byte[] sm3Hash = Hex.decodeHex(sm3HexString.toCharArray());
            SM3Digest digest = new SM3Digest();
            digest.update(srcData, 0, srcData.length);
            byte[] hash = new byte[digest.getDigestSize()];
            digest.doFinal(hash, 0);
            if (Arrays.equals(hash, sm3Hash)) {
                flag = true;
            }
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
