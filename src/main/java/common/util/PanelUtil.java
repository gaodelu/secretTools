package common.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelUtil {

    public static String getDataFromScrollPanel(ActionEvent event,int index){
        Component componentData = ((JButton) event.getSource()).getParent().getComponent(index);
        Component[] component = ((JScrollPane) componentData).getViewport().getComponents();
        return ((JTextArea) component[0]).getText();
    }
}
