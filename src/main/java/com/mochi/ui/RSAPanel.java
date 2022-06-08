package com.mochi.ui;

import com.mochi.actionlistener.RsaActionListener;

import javax.swing.*;
import java.awt.*;

public class RSAPanel extends JPanel {

    public RSAPanel() {
        this.setLayout(null);
        /*
         * 密钥长度
         */
        JLabel jLabelData = new JLabel("bits[长度]:");
        jLabelData.setBounds(10, 20, 120, 30);
        jLabelData.setVisible(true);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setVisible(true);
        jTextArea.setBounds(130, 20, 150, 30);
        jTextArea.setLineWrap(true);
        jTextArea.setText("2048");
        jTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        jScrollPane.setName("bits");
        jScrollPane.setVisible(true);
        jScrollPane.setBounds(130, 20, 150, 30);
        /**
         /*
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
        JScrollPane jScrollPaneN = new JScrollPane(jTextAreaN);
        jScrollPaneN.setName("n");
        jScrollPaneN.setVisible(true);
        jScrollPaneN.setBounds(130, 60, 150, 30);

        /**
         /*
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
        JScrollPane jScrollPaneD = new JScrollPane(jTextAreaD);
        jScrollPaneD.setName("d");
        jScrollPaneD.setVisible(true);
        jScrollPaneD.setBounds(130, 100, 150, 30);


        /**
         /*
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
        JScrollPane jScrollPaneP = new JScrollPane(jTextAreaP);
        jScrollPaneP.setName("p");
        jScrollPaneP.setVisible(true);
        jScrollPaneP.setBounds(130, 140, 150, 30);

        /**
         /*
         * 质数q
         */
        JLabel jLabelDataQ = new JLabel("q[质数2](H):");
        jLabelDataQ.setBounds(10, 180, 120, 30);
        jLabelDataQ.setVisible(true);
        JTextArea jTextAreaQ = new JTextArea();
        jTextAreaQ.setVisible(true);
        jTextAreaQ.setBounds(130, 180, 150, 30);
        jTextAreaQ.setLineWrap(true);
        jTextAreaQ.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        JScrollPane jScrollPaneQ = new JScrollPane(jTextAreaQ);
        jScrollPaneQ.setName("q");
        jScrollPaneQ.setVisible(true);
        jScrollPaneQ.setBounds(130, 180, 150, 30);

        /**
         /*
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
        JScrollPane jScrollPaneDp = new JScrollPane(jTextAreaDp);
        jScrollPaneDp.setName("dp");
        jScrollPaneDp.setVisible(true);
        jScrollPaneDp.setBounds(130, 220, 150, 30);

        /**
         /*
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
        JScrollPane jScrollPaneDq = new JScrollPane(jTextAreaDq);
        jScrollPaneDq.setName("dq");
        jScrollPaneDq.setVisible(true);
        jScrollPaneDq.setBounds(130, 260, 150, 30);


        /**
         /*
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
        JScrollPane jScrollPaneIqp = new JScrollPane(jTextAreaIqp);
        jScrollPaneIqp.setName("invqp");
        jScrollPaneIqp.setVisible(true);
        jScrollPaneIqp.setBounds(130, 300, 150, 30);

        /*左侧列 end*/
        /*右侧列 start*/

        /**
         /*
         * 公钥指数
         */
        JLabel jLabelDataExponent = new JLabel("e[公钥指数](H):");
        jLabelDataExponent.setBounds(300, 20, 100, 30);
        jLabelDataExponent.setVisible(true);
        JTextArea jTextAreaExponent = new JTextArea();
        jTextAreaExponent.setVisible(true);
        jTextAreaExponent.setBounds(410, 20, 100, 30);
        jTextAreaExponent.setLineWrap(true);
        jTextAreaExponent.setText("010001");
        jTextAreaExponent.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        JScrollPane jScrollPaneExponent = new JScrollPane(jTextAreaExponent);
        jScrollPaneExponent.setVisible(true);
        jScrollPaneExponent.setName("e");
        jScrollPaneExponent.setBounds(410, 20, 100, 30);
        jScrollPaneExponent.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         /*
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
        JScrollPane jScrollPanePk = new JScrollPane(jTextAreaPk);
        jScrollPanePk.setName("pkDER");
        jScrollPanePk.setVisible(true);
        jScrollPanePk.setBounds(410, 60, 300, 30);
        jScrollPanePk.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         /*
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

        JScrollPane jScrollPanePv = new JScrollPane(jTextAreaPv);
        jScrollPanePv.setName("pvDER");
        jScrollPanePv.setVisible(true);
        jScrollPanePv.setBounds(410, 100, 300, 30);
        jScrollPanePv.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        /**
         /*
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

        JScrollPane jScrollPaneData = new JScrollPane(jTextAreaData);
        jScrollPaneData.setName("data");
        jScrollPaneData.setVisible(true);
        jScrollPaneData.setBounds(410, 140, 300, 30);
        jScrollPaneData.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        /**
         /*
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

        JScrollPane jScrollPaneResult = new JScrollPane(jTextAreaResult);
        jScrollPaneResult.setName("result");
        jScrollPaneResult.setVisible(true);
        jScrollPaneResult.setBounds(410, 180, 300, 30);
        jScrollPaneResult.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JButton geneRsaButton = new JButton("产生RSA对");
        geneRsaButton.setBounds(10, 360, 200, 50);
        geneRsaButton.setVisible(true);
        geneRsaButton.addActionListener(new RsaActionListener());

        JButton composeDerPk = new JButton("合成DER公钥");
        composeDerPk.setBounds(220, 360, 200, 50);
        composeDerPk.setVisible(true);
        composeDerPk.addActionListener(new RsaActionListener());

        JButton composeDerPv = new JButton("合成DER私钥");
        composeDerPv.setBounds(430, 360, 200, 50);
        composeDerPv.setVisible(true);
        composeDerPv.addActionListener(new RsaActionListener());

        JButton resolveDerPk = new JButton("分解DER公钥");
        resolveDerPk.setBounds(640, 360, 200, 50);
        resolveDerPk.setVisible(true);
        resolveDerPk.addActionListener(new RsaActionListener());

        JButton resolveDerPv = new JButton("分解DER私钥");
        resolveDerPv.setBounds(850, 360, 200, 50);
        resolveDerPv.setVisible(true);
        resolveDerPv.addActionListener(new RsaActionListener());

        JButton pkEncPKCS1 = new JButton("公钥加密（PKCS1）");
        pkEncPKCS1.setBounds(10, 440, 200, 50);
        pkEncPKCS1.setVisible(true);
        pkEncPKCS1.addActionListener(new RsaActionListener());

        JButton pkDecPKCS1 = new JButton("公钥解密（PKCS1）");
        pkDecPKCS1.setBounds(220, 440, 200, 50);
        pkDecPKCS1.setVisible(true);
        pkDecPKCS1.addActionListener(new RsaActionListener());

        JButton pkEnc = new JButton("公钥加密");
        pkEnc.setBounds(430, 440, 200, 50);
        pkEnc.setVisible(true);
        pkEnc.addActionListener(new RsaActionListener());

        JButton pkDec = new JButton("公钥解密");
        pkDec.setBounds(640, 440, 200, 50);
        pkDec.setVisible(true);
        pkDec.addActionListener(new RsaActionListener());

        JButton pvEncPKCS1 = new JButton("私钥加密（PKCS1）");
        pvEncPKCS1.setBounds(10, 520, 200, 50);
        pvEncPKCS1.setVisible(true);
        pvEncPKCS1.addActionListener(new RsaActionListener());

        JButton pvDecPKCS1 = new JButton("私钥解密（PKCS1）");
        pvDecPKCS1.setBounds(220, 520, 200, 50);
        pvDecPKCS1.setVisible(true);
        pvDecPKCS1.addActionListener(new RsaActionListener());

        JButton pvEnc = new JButton("私钥加密");
        pvEnc.setBounds(430, 520, 200, 50);
        pvEnc.setVisible(true);
        pvEnc.addActionListener(new RsaActionListener());

        JButton pvDec = new JButton("私钥解密");
        pvDec.setBounds(640, 520, 200, 50);
        pvDec.setVisible(true);
        pvDec.addActionListener(new RsaActionListener());


        this.add(jLabelData, 0);
        this.add(jScrollPane, 1);
        this.add(jLabelDataExponent, 2);
        this.add(jScrollPaneExponent, 3);
        this.add(jLabelDataN, 4);
        this.add(jScrollPaneN, 5);
        this.add(jLabelDataD, 6);
        this.add(jScrollPaneD, 7);
        this.add(jLabelDataP, 8);
        this.add(jScrollPaneP, 9);
        this.add(jLabelDataQ, 10);
        this.add(jScrollPaneQ, 11);
        this.add(jLabelDataDp, 12);
        this.add(jScrollPaneDp, 13);
        this.add(jLabelDataDq, 14);
        this.add(jScrollPaneDq, 15);
        this.add(jLabelDataPk, 16);
        this.add(jScrollPanePk, 17);
        this.add(jLabelDataPv, 18);
        this.add(jScrollPanePv, 19);
        this.add(jLabelDataData, 20);
        this.add(jScrollPaneData, 21);
        this.add(jLabelDataResult, 22);
        this.add(jScrollPaneResult, 23);
        this.add(jLabelDataIqp, 24);
        this.add(jScrollPaneIqp, 25);
        this.add(geneRsaButton, 26);
        this.add(composeDerPk, 27);
        this.add(composeDerPv, 28);
        this.add(resolveDerPk, 29);
        this.add(resolveDerPv, 30);
        this.add(pkEncPKCS1, 31);
        this.add(pkDecPKCS1, 32);
        this.add(pkEnc, 33);
        this.add(pkDec, 34);
        this.add(pvEncPKCS1, 35);
        this.add(pvDecPKCS1, 36);
        this.add(pvEnc, 37);
        this.add(pvDec, 38);
    }

}
