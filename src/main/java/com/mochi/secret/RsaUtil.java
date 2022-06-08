package com.mochi.secret;

import com.mochi.common.enumutil.Constants;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateCrtKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.security.rsa.RSAPrivateCrtKeyImpl;

import java.math.BigInteger;
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
        BCRSAPrivateCrtKey spec = (BCRSAPrivateCrtKey) rsaPrivateKey;
        result.put(Constants.P, spec.getPrimeP().toString(16).toUpperCase());
        result.put(Constants.Q, spec.getPrimeP().toString(16).toUpperCase());
        result.put(Constants.N, spec.getModulus().toString(16).toUpperCase());
        result.put(Constants.D, spec.getPrivateExponent().toString(16).toUpperCase());
        result.put(Constants.D_P, spec.getPrimeExponentP().toString(16).toUpperCase());
        result.put(Constants.D_Q, spec.getPrimeExponentQ().toString(16).toUpperCase());
        result.put(Constants.INV_Q_P, spec.getCrtCoefficient().toString(16).toUpperCase());
        result.put(Constants.E, spec.getPublicExponent().toString(16).toUpperCase());
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

    public static Map<String,Object> decomposeDerPv(String hexKey) throws NoSuchAlgorithmException, DecoderException, InvalidKeySpecException {
        Map<String, Object> result = new HashMap<>();
        PKCS8EncodedKeySpec x509EncodedKeySpec = new PKCS8EncodedKeySpec(Hex.decodeHex(hexKey.toCharArray()));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(x509EncodedKeySpec);
        RSAPrivateCrtKeyImpl spec = (RSAPrivateCrtKeyImpl) rsaPrivateKey;
        result.put(Constants.P, spec.getPrimeP().toString(16).toUpperCase());
        result.put(Constants.Q, spec.getPrimeP().toString(16).toUpperCase());
        result.put(Constants.N, spec.getModulus().toString(16).toUpperCase());
        result.put(Constants.D, spec.getPrivateExponent().toString(16).toUpperCase());
        result.put(Constants.D_P, spec.getPrimeExponentP().toString(16).toUpperCase());
        result.put(Constants.D_Q, spec.getPrimeExponentQ().toString(16).toUpperCase());
        result.put(Constants.INV_Q_P, spec.getCrtCoefficient().toString(16).toUpperCase());
        result.put(Constants.E, spec.getPublicExponent().toString(16).toUpperCase());
        return result;

    }
}
