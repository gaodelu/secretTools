package com.mochi;

import com.mochi.ui.DataConvertPanel;
import com.mochi.ui.EncryptPanel;
import com.mochi.ui.RSAPanel;
import com.mochi.ui.Sm2Panel;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Application {
    /**
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);
        // 创建及设置窗口
        JFrame frame = new JFrame("secret tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1100, 800);
        frame.setLocation(500, 500);

        //设置选项卡
        JTabbedPane tabbedPanel = new JTabbedPane(1, JTabbedPane.WRAP_TAB_LAYOUT);
        Map<String, JPanel> map = new LinkedHashMap<>();
        map.put("RSA", new RSAPanel());
        map.put("SM2", new Sm2Panel());
        map.put("字符转换", new DataConvertPanel());
        map.put("加解密", new EncryptPanel());
        map.keySet().forEach(secret ->
                tabbedPanel.add(secret, map.get(secret))
        );
        tabbedPanel.addChangeListener(changeEvent -> tabbedPanel.getSelectedIndex());
        tabbedPanel.setVisible(true);
        frame.add(tabbedPanel);
        // 显示窗口
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Application::createAndShowGUI);
    }


}
