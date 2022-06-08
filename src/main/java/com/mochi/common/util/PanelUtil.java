package com.mochi.common.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelUtil {

    public static String getDataFromScrollPanel(ActionEvent event, int index) {
        Component componentData = ((JButton) event.getSource()).getParent().getComponent(index);
        return getDataFromScrollPanel((JScrollPane) componentData);
    }

    public static String getDataFromScrollPanel(JScrollPane scrollPane) {
        Component[] component = scrollPane.getViewport().getComponents();
        return ((JTextArea) component[0]).getText();
    }


    public static String getDataFromJTextArea(ActionEvent event, int index) {
        Component componentData = ((JButton) event.getSource()).getParent().getComponent(index);
        return ((JTextArea) componentData).getText();
    }


    /**
     * 通过组件名,从父级组件沿着递归找到此名字的组件
     *
     * @param c    父级组件
     * @param name 设置的组件名称
     * @return Component 查到的组件
     */
    public static Component searchComponentByName(Container c, String name) {//父级组件,设置的组件名称
        Component result = null;
        Component[] components = c.getComponents();
        if (null != components && components.length > 0) {
            for (Component component : components) {
                String name2 = component.getName();
                if (name2 != null && name2.equals(name)) {
                    result = component;
                    return result;
                } else if (null == result) {//递归调用所有下级组件列表
                    if (component instanceof Container)
                        result = searchComponentByName((Container) component, name);
                }
            }
        }
        return result;
    }
}
