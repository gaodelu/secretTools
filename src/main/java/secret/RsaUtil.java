package secret;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;

/**
 * RSA加解密工具类
 */
public class RsaUtil {

    public static void generateKey(int keySize, String publicExponent) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA", new BouncyCastleProvider());
        RSAKeyGenParameterSpec rsaKeyGenParameterSpec = new RSAKeyGenParameterSpec(keySize, new BigInteger(publicExponent));
        rsa.initialize(rsaKeyGenParameterSpec);
        KeyPair keyPair = rsa.genKeyPair();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        BigInteger privateExponent = rsaPrivateKey.getPrivateExponent();
        System.out.println("私钥指数：" + privateExponent);
        System.out.println(Hex.encodeHexString(rsaPrivateKey.getEncoded()));
        System.out.println(Hex.encodeHexString(rsaPublicKey.getEncoded()));
    }
}
