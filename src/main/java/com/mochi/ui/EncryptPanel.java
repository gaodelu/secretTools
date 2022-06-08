package com.mochi.ui;

import com.mochi.actionlistener.EncryptActionListener;

import javax.swing.*;

public class EncryptPanel extends JPanel {

    public EncryptPanel() {
        this.setLayout(null);
        /**
         * 数据区域
         */
        JLabel jLabelData = new JLabel("data(H):");
        jLabelData.setBounds(10, 20, 60, 30);
        jLabelData.setVisible(true);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setVisible(true);
        jTextArea.setBounds(70, 20, 1000, 30);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVisible(true);
        jScrollPane.setBounds(70, 20, 1000, 30);
        /**
         * 密钥区域
         */
        JLabel jLabelKey = new JLabel("key(H):");
        jLabelKey.setBounds(10, 60, 60, 30);
        jLabelKey.setVisible(true);
        JTextArea keyArea = new JTextArea();
        keyArea.setVisible(true);
        keyArea.setBounds(70, 60, 1000, 30);
        JScrollPane jScrollPaneKey = new JScrollPane(keyArea);
        jScrollPaneKey.setVisible(true);
        jScrollPaneKey.setBounds(70, 60, 1000, 30);
        /**
         * 偏移量
         */
        JLabel jLabelIv = new JLabel("iv(H):");
        jLabelIv.setBounds(10, 100, 60, 30);
        jLabelIv.setVisible(true);
        JTextArea ivArea = new JTextArea();
        ivArea.setVisible(true);
        ivArea.setBounds(70, 100, 1000, 30);
        JScrollPane jScrollPaneIv = new JScrollPane(ivArea);
        jScrollPaneIv.setVisible(true);
        jScrollPaneIv.setBounds(70, 100, 1000, 30);
        /**
         * data1
         */
        JLabel jLabelData1 = new JLabel("data1(H):");
        jLabelData1.setBounds(10, 140, 60, 30);
        jLabelData1.setVisible(true);
        JTextArea dataArea = new JTextArea();
        dataArea.setVisible(true);
        dataArea.setBounds(70, 140, 1000, 30);
        JScrollPane jScrollPaneData1 = new JScrollPane(dataArea);
        jScrollPaneData1.setVisible(true);
        jScrollPaneData1.setBounds(70, 140, 1000, 30);

        /**
         * 密钥类型
         */

        JLabel secretTypeLabel = new JLabel("密钥类型：");
        secretTypeLabel.setBounds(10, 180, 80, 30);
        secretTypeLabel.setVisible(true);
        JRadioButton secretTypeDes = new JRadioButton("Des", true);//只传了两个参数
        secretTypeDes.setVisible(true);
        secretTypeDes.setBounds(100, 180, 100, 30);
        secretTypeDes.addActionListener(new EncryptActionListener());
        JRadioButton secretTypeAes = new JRadioButton("Aes");
        secretTypeAes.setBounds(220, 180, 100, 30);
        secretTypeAes.setVisible(true);
        secretTypeAes.addActionListener(new EncryptActionListener());
        JRadioButton secretTypeSM4 = new JRadioButton("SM4");
        secretTypeSM4.setBounds(340, 180, 100, 30);
        secretTypeSM4.setVisible(true);
        secretTypeSM4.addActionListener(new EncryptActionListener());
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(secretTypeDes);
        buttonGroup.add(secretTypeAes);
        buttonGroup.add(secretTypeSM4);

        /**
         * 按钮
         */
        JButton keyCheckDigitButton = new JButton("密钥奇校验");
        keyCheckDigitButton.setBounds(10, 220, 100, 50);
        keyCheckDigitButton.setVisible(true);
        keyCheckDigitButton.addActionListener(new EncryptActionListener());
        JButton keyCheckValueButton = new JButton("密钥校验值");
        keyCheckValueButton.setBounds(120, 220, 100, 50);
        keyCheckValueButton.setVisible(true);
        keyCheckValueButton.addActionListener(new EncryptActionListener());
        JButton dataCheckDigitButton = new JButton("data奇校验");
        dataCheckDigitButton.setBounds(230, 220, 100, 50);
        dataCheckDigitButton.setVisible(true);
        dataCheckDigitButton.addActionListener(new EncryptActionListener());
        JButton dataCheckValueButton = new JButton("data校验值");
        dataCheckValueButton.setBounds(340, 220, 100, 50);
        dataCheckValueButton.setVisible(true);
        dataCheckValueButton.addActionListener(new EncryptActionListener());
        JButton dataXorData1Button = new JButton("dataXordata1");
        dataXorData1Button.setBounds(450, 220, 100, 50);
        dataXorData1Button.setVisible(true);
        dataXorData1Button.addActionListener(new EncryptActionListener());
        JButton x919Button = new JButton("X9.19");
        x919Button.setBounds(560, 220, 100, 50);
        x919Button.setVisible(true);
        x919Button.addActionListener(new EncryptActionListener());

        JButton ecbEncryptButton = new JButton("ECB加密");
        ecbEncryptButton.setBounds(10, 290, 100, 50);
        ecbEncryptButton.setVisible(true);
        ecbEncryptButton.addActionListener(new EncryptActionListener());
        JButton ecbDecryptButton = new JButton("ECB解密");
        ecbDecryptButton.setBounds(120, 290, 100, 50);
        ecbDecryptButton.setVisible(true);
        ecbDecryptButton.addActionListener(new EncryptActionListener());
        JButton cbcEncryptButton = new JButton("CBC加密");
        cbcEncryptButton.setBounds(230, 290, 100, 50);
        cbcEncryptButton.setVisible(true);
        cbcEncryptButton.addActionListener(new EncryptActionListener());
        JButton cbcDecryptButton = new JButton("CBC解密");
        cbcDecryptButton.setBounds(340, 290, 100, 50);
        cbcDecryptButton.setVisible(true);
        cbcDecryptButton.addActionListener(new EncryptActionListener());
        this.add(jLabelData, 0);
        this.add(jScrollPane, 1);
        this.add(jLabelKey, 2);
        this.add(jScrollPaneKey, 3);
        this.add(keyCheckDigitButton, 4);
        this.add(keyCheckValueButton, 5);
        this.add(dataCheckDigitButton, 6);

        /*
         * 结果区
         */
        JLabel resultLabel = new JLabel("Result(H):");
        resultLabel.setBounds(10, 400, 500, 50);
        resultLabel.setVisible(true);
        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 450, 1000, 100);
        resultArea.setVisible(true);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        JScrollPane jScrollPaneResult = new JScrollPane(resultArea);
        jScrollPaneResult.setVisible(true);
        jScrollPaneResult.setBounds(10, 450, 1000, 100);
        this.add(resultLabel, 7);
        this.add(jScrollPaneResult, 8);
        this.add(jScrollPaneIv, 9);
        this.add(jLabelIv, 10);
        this.add(jScrollPaneData1, 11);
        this.add(jLabelData1, 12);
        this.add(secretTypeLabel, 13);
        this.add(secretTypeDes, 14);
        this.add(secretTypeAes, 15);
        this.add(secretTypeSM4, 16);
        this.add(dataCheckValueButton, 17);
        this.add(dataXorData1Button, 18);
        this.add(x919Button, 19);
        this.add(ecbEncryptButton, 20);
        this.add(ecbDecryptButton, 21);
        this.add(cbcEncryptButton, 22);
        this.add(cbcDecryptButton, 23);
        this.setVisible(true);
    }
}
