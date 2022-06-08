package secret;

import common.enumutil.Constants;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.*;
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


    public static String geneneratePublicKey(String key, String publicExponent) throws InvalidKeySpecException, NoSuchAlgorithmException {
        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(key, 16), BigInteger.valueOf(Long.valueOf(publicExponent, 16)));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return Hex.encodeHexString(publicKey.getEncoded()).toUpperCase();
    }

    public static String decomposeDerpk(String hexKey) throws DecoderException, NoSuchAlgorithmException, InvalidKeySpecException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Hex.decodeHex(hexKey.toCharArray()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
        BigInteger modulus = publicKey.getModulus();
        return modulus.toString(16).toUpperCase();
    }
}
