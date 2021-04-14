package actionlistener;

import common.enumutil.ResponseEnum;
import common.exception.BusinessException;
import common.util.PanelUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataSwitchActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String data = PanelUtil.getDataFromScrollPanel(e,1);//数据
            String resultString = getResultString(e, data);
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(20);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            ((JTextArea) componentResults[0]).setText(resultString);
        } catch (BusinessException businessException) {
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(20);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            ((JTextArea) componentResults[0]).setText(businessException.getMsg());
        } catch (Exception exception) {
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(20);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            ((JTextArea) componentResults[0]).setText(exception.getMessage());
        }
    }

    private String getResultString(ActionEvent e, String data) throws DecoderException, NoSuchAlgorithmException {
        if (data == null || data.length() == 0) {
            throw new BusinessException(ResponseEnum.PB_0002.getRespCode(), ResponseEnum.PB_0002.getRespMsg());
        }
        switch (e.getActionCommand()) {
            case "HEX->ASCII":
                return new String(Hex.decodeHex(data.toCharArray()), StandardCharsets.UTF_8);
            case "ASCII->HEX":
                return Hex.encodeHexString(data.getBytes(StandardCharsets.UTF_8)).toUpperCase();
            case "HEX->BASE64":
                return Base64.encodeBase64String(data.getBytes());
            case "BASE64->HEX":
                return new String(Base64.decodeBase64(data.getBytes())).toUpperCase();
            case "HEX->BASE64UrlSafe":
                return new String(Base64.encodeBase64URLSafe(data.getBytes()));
            case "SHA1(H)":
                return DigestUtils.sha1Hex(data.getBytes()).toUpperCase();
            case "MD5(H)":
                return DigestUtils.md5Hex(data).toUpperCase();
            case "trimSpace":
                return data.replaceAll("\\s*", "");
            case "UPPER":
                return data.toUpperCase();
            case "lower":
                return data.toLowerCase();
            case "SHA256(H)":
                return DigestUtils.sha256Hex(data.getBytes()).toUpperCase();
            case "SHA512(H)":
                return DigestUtils.sha512Hex(data.getBytes()).toUpperCase();
            case "SHA224(H)":
                return getSha224Result(data, "SHA-224");
            case "SHA384(H)":
                return getSha224Result(data, "SHA-384");
            case "ASCII->BASE64":
                return Base64.encodeBase64String(Hex.encodeHexString(data.getBytes(StandardCharsets.UTF_8)).toUpperCase().getBytes());
            case "BASE64->ASCII":
                return new String(Hex.decodeHex((new String(Base64.decodeBase64(data.getBytes())).toUpperCase()).toCharArray()), StandardCharsets.UTF_8);
            case "ASCII->BASE64UrlSafe":
                return new String(Base64.encodeBase64URLSafe(Hex.encodeHexString(data.getBytes(StandardCharsets.UTF_8)).toUpperCase().getBytes()));
            default:
                throw new BusinessException(ResponseEnum.PB_0001.getRespCode(), ResponseEnum.PB_0001.getRespMsg());
        }
    }

    private String getSha224Result(String data, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest sha224 = MessageDigest.getInstance(algorithm);
        return Hex.encodeHexString(sha224.digest(data.getBytes())).toUpperCase();
    }
}
