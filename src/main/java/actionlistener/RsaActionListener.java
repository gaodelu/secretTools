package actionlistener;

import common.util.PanelUtil;
import secret.RsaUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class RsaActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Map<String,String> resultString = getResultString(e);

        //根据按钮操作,跳转指定方法
        switch (e.getActionCommand()) {
            case "产生RSA公私钥对":
                //获取密钥长度
                int bits = Integer.parseInt(PanelUtil.getDataFromScrollPanel(e, 1));
                //获取公钥指数
                String publicExponent = PanelUtil.getDataFromScrollPanel(e, 3);
                try {
                    RsaUtil.generateKey(bits, publicExponent);
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                } catch (InvalidAlgorithmParameterException ex) {
                    ex.printStackTrace();
                }
            default:
                System.out.println("");
        }
        /*Component componentResult = ((JButton) e.getSource()).getParent().getComponent(20);
        Component[] componentResults = ((JScrollPane) componentResult).getViewport().getComponents();
        ((JTextArea) componentResults[0]).setText(resultString);*/


    }

    private Map<String,String> getResultString(ActionEvent e) {
        return null;

    }
}
