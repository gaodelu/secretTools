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
        jLabelDataExponent.setBounds(270, 20, 60, 30);
        jLabelDataExponent.setVisible(true);
        JTextArea jTextAreaExponent = new JTextArea();
        jTextAreaExponent.setVisible(true);
        jTextAreaExponent.setBounds(340, 20, 100, 30);
        jTextAreaExponent.setLineWrap(true);
        jTextAreaExponent.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

        /**
         * 密钥长度
         */
        JLabel jLabelDataM = new JLabel("m(H):");
        jLabelDataM.setBounds(10, 60, 60, 30);
        jLabelDataM.setVisible(true);
        JTextArea jTextAreaM = new JTextArea();
        jTextAreaM.setVisible(true);
        jTextAreaM.setBounds(80, 60, 150, 30);
        jTextAreaM.setLineWrap(true);
        jTextAreaM.setBorder(BorderFactory.createLineBorder(Color.gray, 1));


        this.add(jLabelData, 0);
        this.add(jTextArea, 1);
        this.add(jLabelDataExponent, 2);
        this.add(jTextAreaExponent, 3);
        this.add(jLabelDataM, 4);
        this.add(jTextAreaM, 5);
    }
}
