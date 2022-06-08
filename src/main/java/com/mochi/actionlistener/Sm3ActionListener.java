package com.mochi.actionlistener;

import com.mochi.common.util.PanelUtil;
import com.mochi.secret.SM3Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sm3ActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String data = PanelUtil.getDataFromScrollPanel(e,1);//数据
            String hmac = PanelUtil.getDataFromScrollPanel(e,21);//hmac
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(20);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            if (hmac == null || hmac.length() == 0) {
                ((JTextArea) componentResults[0]).setText(SM3Util.encrypt(data));
            } else {
                ((JTextArea) componentResults[0]).setText(SM3Util.hmac(hmac, data));
            }
        } catch (Exception exception) {
            Component componentResult = ((JButton) e.getSource()).getParent().getComponent(20);
            Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
            ((JTextArea) componentResults[0]).setText(exception.getMessage());
        }
    }
}
