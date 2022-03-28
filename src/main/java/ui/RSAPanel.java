package ui;

import javax.swing.*;
import java.awt.*;

public class RSAPanel extends JPanel {

    public RSAPanel() {
        this.setLayout(null);
        /**
         * 密钥长度
         */
        JLabel jLabelData = new JLabel("bits:");
        jLabelData.setBounds(10, 20, 60, 30);
        jLabelData.setVisible(true);
        JTextArea jTextArea = new JTextArea();
        jTextArea.setVisible(true);
        jTextArea.setBounds(80, 20, 150, 30);
        jTextArea.setLineWrap(true);
        jTextArea.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * 公钥指数
         */
        JLabel jLabelDataExponent = new JLabel("e(H):");
        jLabelDataExponent.setBounds(370, 20, 60, 30);
        jLabelDataExponent.setVisible(true);
        JTextArea jTextAreaExponent = new JTextArea();
        jTextAreaExponent.setVisible(true);
        jTextAreaExponent.setBounds(450, 20, 100, 30);
        jTextAreaExponent.setLineWrap(true);
        jTextAreaExponent.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * 密钥
         */
        JLabel jLabelDataM = new JLabel("m(H):");
        jLabelDataM.setBounds(10, 60, 60, 30);
        jLabelDataM.setVisible(true);
        JTextArea jTextAreaM = new JTextArea();
        jTextAreaM.setVisible(true);
        jTextAreaM.setBounds(80, 60, 150, 30);
        jTextAreaM.setLineWrap(true);
        jTextAreaM.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataD = new JLabel("d(H):");
        jLabelDataD.setBounds(10, 100, 60, 30);
        jLabelDataD.setVisible(true);
        JTextArea jTextAreaD = new JTextArea();
        jTextAreaD.setVisible(true);
        jTextAreaD.setBounds(80, 100, 150, 30);
        jTextAreaD.setLineWrap(true);
        jTextAreaD.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataP = new JLabel("p(H):");
        jLabelDataP.setBounds(10, 140, 60, 30);
        jLabelDataP.setVisible(true);
        JTextArea jTextAreaP = new JTextArea();
        jTextAreaP.setVisible(true);
        jTextAreaP.setBounds(80, 140, 150, 30);
        jTextAreaP.setLineWrap(true);
        jTextAreaP.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        JLabel jLabelDataQ = new JLabel("q(H):");
        jLabelDataQ.setBounds(10, 180, 60, 30);
        jLabelDataQ.setVisible(true);
        JTextArea jTextAreaQ = new JTextArea();
        jTextAreaQ.setVisible(true);
        jTextAreaQ.setBounds(80, 180, 150, 30);
        jTextAreaQ.setLineWrap(true);
        jTextAreaQ.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataDP = new JLabel("dp(H):");
        jLabelDataDP.setBounds(10, 220, 60, 30);
        jLabelDataDP.setVisible(true);
        JTextArea jTextAreaDP = new JTextArea();
        jTextAreaDP.setVisible(true);
        jTextAreaDP.setBounds(80, 220, 150, 30);
        jTextAreaDP.setLineWrap(true);
        jTextAreaDP.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataDQ = new JLabel("dq(H):");
        jLabelDataDQ.setBounds(10, 260, 60, 30);
        jLabelDataDQ.setVisible(true);
        JTextArea jTextAreaDQ = new JTextArea();
        jTextAreaDQ.setVisible(true);
        jTextAreaDQ.setBounds(80, 260, 150, 30);
        jTextAreaDQ.setLineWrap(true);
        jTextAreaDQ.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataQinv = new JLabel("qinv(H):");
        jLabelDataQinv.setBounds(10, 300, 60, 30);
        jLabelDataQinv.setVisible(true);
        JTextArea jTextAreaQinv = new JTextArea();
        jTextAreaQinv.setVisible(true);
        jTextAreaQinv.setBounds(80, 300, 150, 30);
        jTextAreaQinv.setLineWrap(true);
        jTextAreaQinv.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataPkDer = new JLabel("pkDer(H):");
        jLabelDataPkDer.setBounds(370, 60, 60, 30);
        jLabelDataPkDer.setVisible(true);
        JTextArea jTextAreaPkDer = new JTextArea();
        jTextAreaPkDer.setVisible(true);
        jTextAreaPkDer.setBounds(450, 60, 300, 30);
        jTextAreaPkDer.setLineWrap(true);
        jTextAreaPkDer.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataVkDer = new JLabel("vkDer(H):");
        jLabelDataVkDer.setBounds(370, 100, 60, 30);
        jLabelDataVkDer.setVisible(true);
        JTextArea jTextAreaVkDer = new JTextArea();
        jTextAreaVkDer.setVisible(true);
        jTextAreaVkDer.setBounds(450, 100, 300, 30);
        jTextAreaVkDer.setLineWrap(true);
        jTextAreaVkDer.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataData = new JLabel("data(H):");
        jLabelDataData.setBounds(370, 140, 60, 30);
        jLabelDataData.setVisible(true);
        JTextArea jTextAreaData = new JTextArea();
        jTextAreaData.setVisible(true);
        jTextAreaData.setBounds(450, 140, 300, 30);
        jTextAreaData.setLineWrap(true);
        jTextAreaData.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        JLabel jLabelDataResult = new JLabel("result(H):");
        jLabelDataResult.setBounds(370, 180, 60, 30);
        jLabelDataResult.setVisible(true);
        JTextArea jTextAreaResult = new JTextArea();
        jTextAreaResult.setVisible(true);
        jTextAreaResult.setBounds(450, 180, 300, 30);
        jTextAreaResult.setLineWrap(true);
        jTextAreaResult.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        this.add(jLabelData, 0);
        this.add(jTextArea, 1);
        this.add(jLabelDataExponent, 2);
        this.add(jTextAreaExponent, 3);
        this.add(jLabelDataM, 4);
        this.add(jTextAreaM, 5);
        this.add(jLabelDataD, 6);
        this.add(jTextAreaD, 7);
        this.add(jLabelDataP, 8);
        this.add(jTextAreaP, 9);
        this.add(jLabelDataQ, 10);
        this.add(jTextAreaQ, 11);
        this.add(jLabelDataDP, 12);
        this.add(jTextAreaDP, 13);
        this.add(jLabelDataDQ, 14);
        this.add(jTextAreaDQ, 15);
        this.add(jLabelDataPkDer, 16);
        this.add(jTextAreaPkDer, 17);
        this.add(jLabelDataVkDer, 18);
        this.add(jTextAreaVkDer, 19);
        this.add(jLabelDataData, 20);
        this.add(jTextAreaData, 21);
        this.add(jLabelDataResult, 22);
        this.add(jTextAreaResult, 23);
        this.add(jLabelDataQinv, 24);
        this.add(jTextAreaQinv, 25);
    }

}
