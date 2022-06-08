package com.mochi.actionlistener;

import com.mochi.common.enumutil.ResponseEnum;
import com.mochi.common.exception.BusinessException;
import com.mochi.common.util.PanelUtil;
import com.mochi.common.util.StringUtil;
import com.mochi.secret.AesUtil;
import com.mochi.secret.DesUtil;
import com.mochi.secret.SM4Util;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

public class EncryptActionListener implements ActionListener {

    private static String selectedAlgorithm = "DES";

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equalsIgnoreCase("DES")
                    || e.getActionCommand().equalsIgnoreCase("AES")
                    || e.getActionCommand().equalsIgnoreCase("SM4")) {
                selectedAlgorithm = e.getActionCommand().toUpperCase();
                dealEncryptType(e);
                return;
            }
            String data = PanelUtil.getDataFromScrollPanel(e, 1);//数据
            String key = PanelUtil.getDataFromScrollPanel(e, 3);//密钥
            String iv = PanelUtil.getDataFromScrollPanel(e, 9);//初始向量
            String data1 = PanelUtil.getDataFromScrollPanel(e, 11);//data1
            String resultString = getResultString(e, data, key, iv, selectedAlgorithm, data1);
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(8);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            ((JTextArea) componentResults[0]).setText(resultString);
        } catch (BusinessException exception) {
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(8);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            ((JTextArea) componentResults[0]).setText(exception.getMsg());
        } catch (Exception exception) {
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(8);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            ((JTextArea) componentResults[0]).setText(exception.getMessage());
        }
    }

    private void dealEncryptType(ActionEvent e) {
        //如果是DES，关闭密钥奇校验和data奇校验  4 5 6 17
        Component componentButton = ((JRadioButton) e.getSource()).getParent().getComponent(4);
        //Component componentButton1 = ((JRadioButton) e.getSource()).getParent().getComponent(5);
        Component componentButton2 = ((JRadioButton) e.getSource()).getParent().getComponent(6);
        Component componentButton3 = ((JRadioButton) e.getSource()).getParent().getComponent(19);
        if ("DES".equalsIgnoreCase(e.getActionCommand())) {
            componentButton.setEnabled(true);
            componentButton2.setEnabled(true);
            componentButton3.setEnabled(true);
        } else {
            componentButton.setEnabled(false);
            componentButton2.setEnabled(false);
            componentButton3.setEnabled(false);
        }

    }

    private String getResultString(ActionEvent e, String data, String key, String iv, String algorithm, String data1) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, InvalidKeyException, InvalidAlgorithmParameterException {
        switch (e.getActionCommand()) {
            case "SM4加密":
                return SM4Util.encryptEcb(key, data,iv).toUpperCase();
            case "SM4解密":
                return SM4Util.decryptEcb(key, data,iv).toUpperCase();
            case "密钥奇校验":
                return keyOddCheck(key);
            case "data奇校验":
                return keyOddCheck(data);
            case "ECB加密":
                return getEncryptData(data, key, "", algorithm);
            case "ECB解密":
                return getDecryptData(data, key, "", algorithm);
            case "CBC加密":
                return getEncryptData(data, key, iv, algorithm);
            case "CBC解密":
                return getDecryptData(data, key, iv, algorithm);
            case "密钥校验值":
                return getEncryptData("0000000000000000", key, "", algorithm);
            case "data校验值":
                return getEncryptData("0000000000000000", data, "", algorithm);
            case "dataXordata1":
                return xor(data, data1);
            case "X9.19":
                return "开发中";
            default:
                throw new BusinessException(ResponseEnum.PB_0001.getRespCode(), ResponseEnum.PB_0001.getRespMsg());
        }
    }


    private String getDecryptData(String data, String key, String iv, String algorithm) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        if ("DES".equals(algorithm)) {
            return DesUtil.decrypt(key, data, iv);
        }
        if ("AES".equals(algorithm)) {
            return AesUtil.decrypt(key, data, iv);
        }
        if ("SM4".equalsIgnoreCase(algorithm)) {
            return SM4Util.decryptEcb(key, data, iv);
        }
        return "";
    }

    private String getEncryptData(String data, String key, String iv, String algorithm) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException {
        if ("DES".equals(algorithm)) {
            return DesUtil.encrypt(key, data, iv);
        }
        if ("AES".equals(algorithm)) {
            return AesUtil.encrypt(key, data, iv);
        }
        if ("SM4".equals(algorithm)) {
            return SM4Util.encryptEcb(key, data, iv);
        }
        return "";
    }


    private String keyOddCheck(String key) {
        String binaryString = StringUtil.hexString2binaryString(key);
        List<String> binaryList = StringUtil.getStrList(binaryString, 8);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < binaryList.size(); i++) {
            String binary = binaryList.get(i);
            if (i == binaryList.size() - 1) {
                result.append(binary);
                continue;
            }
            int count = StringUtil.getCount(binary, "1");
            if (count % 2 == 0) {
                binary = StringUtil.replaceLastChar(binary, binary.endsWith("1") ? "0" : "1");
            }
            result.append(binary);
        }
        return StringUtil.binaryString2hexString(result.toString());
    }


    private String xor(String data, String data1) {
        if (data.length() != data1.length()) {
            throw new BusinessException(ResponseEnum.PB_0007.getRespCode(), ResponseEnum.PB_0007.getRespMsg());
        }
        String dataBinary = StringUtil.hexString2binaryString(data);
        String data1Binary = StringUtil.hexString2binaryString(data1);
        List<String> dataBinaryList = StringUtil.getStrList(dataBinary, 1);
        List<String> data1BinaryList = StringUtil.getStrList(data1Binary, 1);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dataBinaryList.size(); i++) {
            if (dataBinaryList.get(i).equals(data1BinaryList.get(i))) {
                result.append("0");
            } else {
                result.append("1");
            }
        }
        return StringUtil.binaryString2hexString(result.toString());
    }

}
