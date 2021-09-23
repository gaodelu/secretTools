package ui;

import actionlistener.RsaActionListener;

import javax.swing.*;
import java.awt.*;

public class RSAPanel extends JPanel {

    public RSAPanel() {
        this.setLayout(null);
        /*左侧列 start*/

        /**
         * 密钥长度
         */
        JLabel jLabelData = new JLabel("bits[长度]:");
        jLabelData.setBounds(10, 20, 120, 30);
        jLabelData.setVisible(true);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setVisible(true);
        jTextArea.setBounds(130, 20, 150, 30);
        jTextArea.setLineWrap(true);
        jTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * 公钥
         */
        JLabel jLabelDataN = new JLabel("n[公钥](H):");
        jLabelDataN.setBounds(10, 60, 120, 30);
        jLabelDataN.setVisible(true);
        JTextArea jTextAreaN = new JTextArea();
        jTextAreaN.setVisible(true);
        jTextAreaN.setBounds(130, 60, 150, 30);
        jTextAreaN.setLineWrap(true);
        jTextAreaN.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        /**
         * 私钥指数D
         */
        JLabel jLabelDataD = new JLabel("d[私钥指数](H):");
        jLabelDataD.setBounds(10, 100, 120, 30);
        jLabelDataD.setVisible(true);
        JTextArea jTextAreaD = new JTextArea();
        jTextAreaD.setVisible(true);
        jTextAreaD.setBounds(130, 100, 150, 30);
        jTextAreaD.setLineWrap(true);
        jTextAreaD.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        /**
         * 质数P
         */
        JLabel jLabelDataP = new JLabel("p[质数1](H):");
        jLabelDataP.setBounds(10, 140, 120, 30);
        jLabelDataP.setVisible(true);
        JTextArea jTextAreaP = new JTextArea();
        jTextAreaP.setVisible(true);
        jTextAreaP.setBounds(130, 140, 150, 30);
        jTextAreaP.setLineWrap(true);
        jTextAreaP.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * 质数q
         */
        JLabel jLabelDataQ = new JLabel("p[质数2](H):");
        jLabelDataQ.setBounds(10, 180, 120, 30);
        jLabelDataQ.setVisible(true);
        JTextArea jTextAreaQ = new JTextArea();
        jTextAreaQ.setVisible(true);
        jTextAreaQ.setBounds(130, 180, 150, 30);
        jTextAreaQ.setLineWrap(true);
        jTextAreaQ.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        /**
         * d mod p-1
         */
        JLabel jLabelDataDp = new JLabel("dp[d mod p-1](H):");
        jLabelDataDp.setBounds(10, 220, 120, 30);
        jLabelDataDp.setVisible(true);
        JTextArea jTextAreaDp = new JTextArea();
        jTextAreaDp.setVisible(true);
        jTextAreaDp.setBounds(130, 220, 150, 30);
        jTextAreaDp.setLineWrap(true);
        jTextAreaDp.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        /**
         * d mod q-1
         */
        JLabel jLabelDataDq = new JLabel("dp[d mod q-1](H):");
        jLabelDataDq.setBounds(10, 260, 120, 30);
        jLabelDataDq.setVisible(true);
        JTextArea jTextAreaDq = new JTextArea();
        jTextAreaDq.setVisible(true);
        jTextAreaDq.setBounds(130, 260, 150, 30);
        jTextAreaDq.setLineWrap(true);
        jTextAreaDq.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * (inverse of q) mod p
         */
        JLabel jLabelDataIqp = new JLabel("invqp[invq mod p](H):");
        jLabelDataIqp.setBounds(10, 300, 120, 30);
        jLabelDataIqp.setVisible(true);
        JTextArea jTextAreaIqp = new JTextArea();
        jTextAreaIqp.setVisible(true);
        jTextAreaIqp.setBounds(130, 300, 150, 30);
        jTextAreaIqp.setLineWrap(true);
        jTextAreaIqp.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /*左侧列 end*/
        /*右侧列 start*/

        /**
         * 公钥指数
         */
        JLabel jLabelDataExponent = new JLabel("e[公钥指数](H):");
        jLabelDataExponent.setBounds(300, 20, 100, 30);
        jLabelDataExponent.setVisible(true);
        JTextArea jTextAreaExponent = new JTextArea();
        jTextAreaExponent.setVisible(true);
        jTextAreaExponent.setBounds(410, 20, 100, 30);
        jTextAreaExponent.setLineWrap(true);
        jTextAreaExponent.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        /**
         * public Key
         */
        JLabel jLabelDataPk = new JLabel("pkDER(H):");
        jLabelDataPk.setBounds(300, 60, 100, 30);
        jLabelDataPk.setVisible(true);
        JTextArea jTextAreaPk = new JTextArea();
        jTextAreaPk.setVisible(true);
        jTextAreaPk.setBounds(410, 60, 300, 30);
        jTextAreaPk.setLineWrap(true);
        jTextAreaPk.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * private Key
         */
        JLabel jLabelDataPv = new JLabel("pvDER(H):");
        jLabelDataPv.setBounds(300, 100, 100, 30);
        jLabelDataPv.setVisible(true);
        JTextArea jTextAreaPv = new JTextArea();
        jTextAreaPv.setVisible(true);
        jTextAreaPv.setBounds(410, 100, 300, 30);
        jTextAreaPv.setLineWrap(true);
        jTextAreaPv.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * data
         */
        JLabel jLabelDataData = new JLabel("data(H):");
        jLabelDataData.setBounds(300, 140, 100, 30);
        jLabelDataData.setVisible(true);
        JTextArea jTextAreaData = new JTextArea();
        jTextAreaData.setVisible(true);
        jTextAreaData.setBounds(410, 140, 300, 30);
        jTextAreaData.setLineWrap(true);
        jTextAreaData.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * result
         */
        JLabel jLabelDataResult = new JLabel("result(H):");
        jLabelDataResult.setBounds(300, 180, 100, 30);
        jLabelDataResult.setVisible(true);
        JTextArea jTextAreaResult = new JTextArea();
        jTextAreaResult.setVisible(true);
        jTextAreaResult.setBounds(410, 180, 300, 30);
        jTextAreaResult.setLineWrap(true);
        jTextAreaResult.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        /* 右侧列 end */

        /* 按钮区 start */
        JButton geneRsaButton = new JButton("产生RSA公私钥对");
        geneRsaButton.setBounds(10, 360, 150, 50);
        geneRsaButton.setVisible(true);
        geneRsaButton.addActionListener(new RsaActionListener());
        JButton geneDerPkButton = new JButton("合成DER公钥");
        geneDerPkButton.setBounds(180, 360, 150, 50);
        geneDerPkButton.setVisible(true);
        geneDerPkButton.addActionListener(new RsaActionListener());
        JButton geneDerPvButton = new JButton("合成DER私钥");
        geneDerPvButton.setBounds(350, 360, 150, 50);
        geneDerPvButton.setVisible(true);
        geneDerPvButton.addActionListener(new RsaActionListener());
        JButton decomposeDerPkButton = new JButton("分解DER公钥");
        decomposeDerPkButton.setBounds(520, 360, 150, 50);
        decomposeDerPkButton.setVisible(true);
        decomposeDerPkButton.addActionListener(new RsaActionListener());
        JButton decomposeDerPvButton = new JButton("分解DER私钥");
        decomposeDerPvButton.setBounds(690, 360, 150, 50);
        decomposeDerPvButton.setVisible(true);
        decomposeDerPvButton.addActionListener(new RsaActionListener());



        JButton pkEncPkcs1Button = new JButton("公钥加密(PKCS1)");
        pkEncPkcs1Button.setBounds(10, 430, 150, 50);
        pkEncPkcs1Button.setVisible(true);
        pkEncPkcs1Button.addActionListener(new RsaActionListener());
        JButton pkDecPkcs1Button = new JButton("公钥解密(PKCS1)");
        pkDecPkcs1Button.setBounds(180, 430, 150, 50);
        pkDecPkcs1Button.setVisible(true);
        pkDecPkcs1Button.addActionListener(new RsaActionListener());
        JButton pkEncButton = new JButton("公钥加密");
        pkEncButton.setBounds(350, 430, 150, 50);
        pkEncButton.setVisible(true);
        pkEncButton.addActionListener(new RsaActionListener());
        JButton pkDecButton = new JButton("公钥解密");
        pkDecButton.setBounds(520, 430, 150, 50);
        pkDecButton.setVisible(true);
        pkDecButton.addActionListener(new RsaActionListener());

        JButton pvEncPkcs1Button = new JButton("私钥加密(PKCS1)");
        pvEncPkcs1Button.setBounds(10, 500, 150, 50);
        pvEncPkcs1Button.setVisible(true);
        pvEncPkcs1Button.addActionListener(new RsaActionListener());
        JButton pvDecPkcs1Button = new JButton("私钥解密(PKCS1)");
        pvDecPkcs1Button.setBounds(180, 500, 150, 50);
        pvDecPkcs1Button.setVisible(true);
        pvDecPkcs1Button.addActionListener(new RsaActionListener());
        JButton pvEncButton = new JButton("私钥加密");
        pvEncButton.setBounds(350, 500, 150, 50);
        pvEncButton.setVisible(true);
        pvEncButton.addActionListener(new RsaActionListener());
        JButton pvDecButton = new JButton("私钥解密");
        pvDecButton.setBounds(520, 500, 150, 50);
        pvDecButton.setVisible(true);
        pvDecButton.addActionListener(new RsaActionListener());


        this.add(jLabelData, 0);
        this.add(jTextArea, 1);
        this.add(jLabelDataExponent, 2);
        this.add(jTextAreaExponent, 3);
        this.add(jLabelDataN, 4);
        this.add(jTextAreaN, 5);
        this.add(jLabelDataD, 6);
        this.add(jTextAreaD, 7);
        this.add(jLabelDataP, 8);
        this.add(jTextAreaP, 9);
        this.add(jLabelDataQ, 10);
        this.add(jTextAreaQ, 11);
        this.add(jLabelDataDp, 12);
        this.add(jTextAreaDp, 13);
        this.add(jLabelDataDq, 14);
        this.add(jTextAreaDq, 15);
        this.add(jLabelDataIqp, 16);
        this.add(jTextAreaIqp, 17);
        this.add(jLabelDataPk, 18);
        this.add(jTextAreaPk, 19);
        this.add(jLabelDataPv, 20);
        this.add(jTextAreaPv, 21);
        this.add(jLabelDataData, 22);
        this.add(jTextAreaData, 23);
        this.add(jLabelDataResult, 24);
        this.add(jTextAreaResult, 25);
        this.add(geneRsaButton, 26);
        this.add(geneDerPkButton, 27);
        this.add(geneDerPvButton, 28);
        this.add(decomposeDerPkButton, 29);
        this.add(decomposeDerPvButton, 30);
        this.add(pkEncPkcs1Button, 31);
        this.add(pkDecPkcs1Button, 32);
        this.add(pkEncButton, 33);
        this.add(pkDecButton, 34);
        this.add(pvEncPkcs1Button, 35);
        this.add(pvDecPkcs1Button, 36);
        this.add(pvEncButton, 37);
        this.add(pvDecButton, 38);
    }
}
