package com.mochi.secret;

import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.gm.GMObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class SM2Util {

    private static PublicKey publicKey;

    private static PrivateKey privateKey;

    private static Signature signature;

    public static void generateSm2Key() throws Exception {
        ECGenParameterSpec sm2Spec = new ECGenParameterSpec("sm2p256v1");
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC", new BouncyCastleProvider());
        kpg.initialize(sm2Spec);
        //kpg.initialize(sm2Spec, new SecureRandom());
        KeyPair keyPair = kpg.generateKeyPair();
        publicKey = keyPair.getPublic();
        System.out.println("pk: \n" + Hex.toHexString(publicKey.getEncoded()));
        System.out.println(Hex.toHexString(getDerPublicKey(publicKey.getEncoded())));
        privateKey = keyPair.getPrivate();
        System.out.println("self Key: \n" + Hex.toHexString(privateKey.getEncoded()));
    }

    public static byte[] getDerPublicKey(byte[] pubkey) throws Exception {
        SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo
                .getInstance(pubkey);

        DERBitString publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
        byte[] publicKey = publicKeyData.getEncoded();
        byte[] encodedPublicKey = publicKey;
        byte[] ecP = new byte[64];
        System.arraycopy(encodedPublicKey, 4, ecP, 0, ecP.length);

        byte[] certPKX = new byte[32];
        byte[] certPKY = new byte[32];
        System.arraycopy(ecP, 0, certPKX, 0, 32);
        System.arraycopy(ecP, 32, certPKY, 0, 32);
        return ecP;
    }

    public static String sign(String plainText) throws Exception {

        signature = Signature.getInstance(
                GMObjectIdentifiers.sm2sign_with_sm3.toString(), new BouncyCastleProvider());

        signature.initSign(privateKey);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));
        byte[] signatureValue = signature.sign();
        System.out.println("signature: \n" + Hex.toHexString(signatureValue));
        signature.initVerify(publicKey);
        signature.update(plainText.getBytes(StandardCharsets.UTF_8));
        System.out.println("Signature verify result:\n" + signature.verify(signatureValue));
        return Hex.toHexString(signatureValue);
    }

}