package ui;

import javax.swing.*;
import java.awt.*;

public class RSAPanel extends JPanel {

    public RSAPanel() {
        this.setBackground(Color.cyan);
        this.setVisible(true);
        JLabel jLabel = new JLabel("RSA算法待解锁，付费6元一个月搞定");
        jLabel.setSize(200,200);
        jLabel.setLocation(100,100);
        jLabel.setVisible(true);
        this.add(jLabel);
    }
}
