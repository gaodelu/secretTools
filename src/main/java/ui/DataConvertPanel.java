package ui;

import actionlistener.*;

import javax.swing.*;

public class DataConvertPanel extends JPanel {

    public DataConvertPanel() {
        this.setLayout(null);

        /**
         * 数据区域
         */
        JLabel jLabelData = new JLabel("data(H):");
        jLabelData.setBounds(10, 0, 500, 50);
        jLabelData.setVisible(true);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setVisible(true);
        jTextArea.setBounds(10, 50, 1000, 100);
        jTextArea.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setVisible(true);
        jScrollPane.setBounds(10, 50, 1000, 100);

        JLabel jLabelDataHmac = new JLabel("hmac(H):");
        jLabelDataHmac.setBounds(10, 150, 500, 50);
        jLabelDataHmac.setVisible(true);
        JTextArea jTextAreaHmac = new JTextArea();
        jTextAreaHmac.setVisible(true);
        jTextAreaHmac.setBounds(10, 200, 1000, 50);
        jTextAreaHmac.setLineWrap(true);
        JScrollPane jScrollPaneHmac = new JScrollPane(jTextAreaHmac);
        jScrollPaneHmac.setVisible(true);
        jScrollPaneHmac.setBounds(10, 200, 1000, 50);
        /**
         * 按钮
         */
        JButton sha1Button = new JButton("SHA1(H)");
        sha1Button.setBounds(10, 255, 150, 50);
        sha1Button.setVisible(true);
        sha1Button.addActionListener(new DataSwitchActionListener());
        JButton md5Button = new JButton("MD5(H)");
        md5Button.setBounds(170, 255, 150, 50);
        md5Button.setVisible(true);
        md5Button.addActionListener(new DataSwitchActionListener());
        JButton sm3Button = new JButton("SM3(H)");
        sm3Button.setBounds(330, 255, 150, 50);
        sm3Button.setVisible(true);
        sm3Button.addActionListener(new Sm3ActionListener());
        JButton trimSpaceButton = new JButton("trimSpace");
        trimSpaceButton.setBounds(500, 255, 150, 50);
        trimSpaceButton.setVisible(true);
        trimSpaceButton.addActionListener(new DataSwitchActionListener());
        JButton upperButton = new JButton("UPPER");
        upperButton.setBounds(670, 255, 150, 50);
        upperButton.setVisible(true);
        upperButton.addActionListener(new DataSwitchActionListener());
        JButton lowerButton = new JButton("lower");
        lowerButton.setBounds(840, 255, 150, 50);
        lowerButton.setVisible(true);
        lowerButton.addActionListener(new DataSwitchActionListener());
        this.add(jLabelData, 0);
        this.add(jScrollPane, 1);
        this.add(sha1Button, 2);
        this.add(md5Button, 3);
        this.add(sm3Button, 4);
        this.add(trimSpaceButton, 5);
        this.add(upperButton, 6);
        this.add(lowerButton, 7);
        /**
         * 按钮
         */
        JButton sha224Button = new JButton("SHA224(H)");
        sha224Button.setBounds(10, 325, 150, 50);
        sha224Button.setVisible(true);
        sha224Button.addActionListener(new DataSwitchActionListener());
        JButton sha256Button = new JButton("SHA256(H)");
        sha256Button.setBounds(170, 325, 150, 50);
        sha256Button.setVisible(true);
        sha256Button.addActionListener(new DataSwitchActionListener());
        JButton sha384Button = new JButton("SHA384(H)");
        sha384Button.setBounds(330, 325, 150, 50);
        sha384Button.setVisible(true);
        sha384Button.addActionListener(new DataSwitchActionListener());
        JButton sha512Button = new JButton("SHA512(H)");
        sha512Button.setBounds(500, 325, 150, 50);
        sha512Button.setVisible(true);
        sha512Button.addActionListener(new DataSwitchActionListener());
        JButton changeC23Button = new JButton("C1C2C3->C1C3C2");
        changeC23Button.setBounds(670, 325, 150, 50);
        changeC23Button.setVisible(true);
        changeC23Button.addActionListener(new DataSwitchActionListener());
        JButton changeC32Button = new JButton("C1C3C2->C1C2C3");
        changeC32Button.setBounds(840, 325, 150, 50);
        changeC32Button.setVisible(true);
        changeC32Button.addActionListener(new DataSwitchActionListener());
        this.add(sha224Button, 8);
        this.add(sha256Button, 9);
        this.add(sha384Button, 10);
        this.add(sha512Button, 11);
        this.add(changeC23Button, 12);
        this.add(changeC32Button, 13);
        JButton hToAButton = new JButton("HEX->ASCII");
        hToAButton.setBounds(10, 395, 150, 50);
        hToAButton.setVisible(true);
        hToAButton.addActionListener(new DataSwitchActionListener());
        JButton aToHButton = new JButton("ASCII->HEX");
        aToHButton.setBounds(170, 395, 150, 50);
        aToHButton.setVisible(true);
        aToHButton.addActionListener(new DataSwitchActionListener());
        JButton hToBaseButton = new JButton("HEX->BASE64");
        hToBaseButton.setBounds(330, 395, 150, 50);
        hToBaseButton.setVisible(true);
        hToBaseButton.addActionListener(new DataSwitchActionListener());
        JButton baseToHButton = new JButton("BASE64->HEX");
        baseToHButton.setBounds(500, 395, 150, 50);
        baseToHButton.setVisible(true);
        baseToHButton.addActionListener(new DataSwitchActionListener());
        JButton hToBaseUrlSafeButton = new JButton("HEX->BASE64UrlSafe");
        hToBaseUrlSafeButton.setBounds(670, 395, 150, 50);
        hToBaseUrlSafeButton.setVisible(true);
        hToBaseUrlSafeButton.addActionListener(new DataSwitchActionListener());
        this.add(hToAButton, 14);
        this.add(aToHButton, 15);
        this.add(hToBaseButton, 16);
        this.add(baseToHButton, 17);
        this.add(hToBaseUrlSafeButton, 18);
        JButton AToBase64Button = new JButton("ASCII->BASE64");
        AToBase64Button.setBounds(10, 465, 150, 50);
        AToBase64Button.setVisible(true);
        AToBase64Button.addActionListener(new DataSwitchActionListener());
        JButton base64ToAButton = new JButton("BASE64->ASCII");
        base64ToAButton.setBounds(170, 465, 150, 50);
        base64ToAButton.setVisible(true);
        base64ToAButton.addActionListener(new DataSwitchActionListener());
        JButton AToBase64SafeButton = new JButton("ASCII->BASE64UrlSafe");
        AToBase64SafeButton.setBounds(330, 465, 150, 50);
        AToBase64SafeButton.setVisible(true);
        AToBase64SafeButton.addActionListener(new DataSwitchActionListener());

        /*
         * 结果区
         */
        JLabel resultLabel = new JLabel("Result(H):");
        resultLabel.setBounds(10, 530, 500, 50);
        resultLabel.setVisible(true);
        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 580, 1000, 100);
        resultArea.setVisible(true);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        JScrollPane jScrollPaneResult = new JScrollPane(resultArea);
        jScrollPaneResult.setVisible(true);
        jScrollPaneResult.setBounds(10, 580, 1000, 100);

        this.add(resultLabel, 19);
        this.add(jScrollPaneResult, 20);
        this.add(jScrollPaneHmac, 21);
        this.add(jLabelDataHmac, 22);
        this.add(AToBase64Button, 23);
        this.add(base64ToAButton, 24);
        this.add(AToBase64SafeButton, 25);
        this.setVisible(true);
    }
}
