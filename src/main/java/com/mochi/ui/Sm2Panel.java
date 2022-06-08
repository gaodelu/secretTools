package com.mochi.ui;

import javax.swing.*;
import java.awt.*;

public class Sm2Panel extends JPanel {

    public Sm2Panel() {
        this.setBackground(Color.cyan);
        this.setVisible(true);
        JLabel jLabel = new JLabel("sm2算法待解锁，付费30元一个月搞定");
        jLabel.setSize(200,200);
        jLabel.setLocation(100,100);
        jLabel.setVisible(true);
        this.add(jLabel);
    }
}
