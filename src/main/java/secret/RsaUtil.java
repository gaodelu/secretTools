package secret;

import common.enumutil.Constants;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加解密工具类
 */
public class RsaUtil {

    public static Map<String, Object> generateKey(int keySize, String publicExponent) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Map<String, Object> result = new HashMap<>();
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA", new BouncyCastleProvider());
        RSAKeyGenParameterSpec rsaKeyGenParameterSpec = new RSAKeyGenParameterSpec(keySize, BigInteger.valueOf(Long.valueOf(publicExponent, 16)));
        rsa.initialize(rsaKeyGenParameterSpec);
        KeyPair keyPair = rsa.genKeyPair();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        result.put(Constants.PUBLIC_KEY, Hex.encodeHexString(rsaPublicKey.getEncoded()).toUpperCase());
        result.put(Constants.PRIVATE_KEY, Hex.encodeHexString(rsaPrivateKey.getEncoded()).toUpperCase());
        return result;
    }
}
