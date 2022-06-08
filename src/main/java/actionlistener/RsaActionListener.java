package actionlistener;

import common.enumutil.Constants;
import common.enumutil.ResponseEnum;
import common.exception.BusinessException;
import common.util.PanelUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.StringUtils;
import secret.RsaUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RsaActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //根据按钮操作,跳转指定方法
        switch (e.getActionCommand()) {
            case "产生RSA对":
                generateRsaKeyPair(e);
                break;
            case "合成DER公钥":
                getDerPk(e);
                break;
            case "合成DER私钥":
                break;
            case "分解DER公钥":
                decomposeDerpk(e);
                break;
            default:
                throw new BusinessException(ResponseEnum.PB_0001.getRespCode(), ResponseEnum.PB_0001.getRespMsg());
        }
    }

    /**
     * 分解DER公钥
     *
     * @param e 按钮事件
     */
    private void decomposeDerpk(ActionEvent e) {
        Container parent = ((JButton) e.getSource()).getParent();
        Component pkDerComponent = PanelUtil.searchComponentByName(parent, "pkDER");
        String pkDer = PanelUtil.getDataFromScrollPanel((JScrollPane) pkDerComponent);
        try {
            String pk = RsaUtil.decomposeDerpk(pkDer);
            Component nComponent = PanelUtil.searchComponentByName(parent, "n");
            ((JTextArea) ((JScrollPane) nComponent).getViewport().getComponents()[0]).setText(pk);
        } catch (DecoderException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            //赋值
            Component resultComponent = PanelUtil.searchComponentByName(parent, "result");
            ((JTextArea) ((JScrollPane) resultComponent).getViewport().getComponents()[0]).setText(ex.getMessage());
        }
    }

    /**
     * 公钥转DER格式
     *
     * @param  e 按钮事件
     */
    private void getDerPk(ActionEvent e) {
        //获取密钥长度
        Container parent = ((JButton) e.getSource()).getParent();
        Component pkExponent = PanelUtil.searchComponentByName(parent, "e");
        String publicExponent = PanelUtil.getDataFromScrollPanel((JScrollPane) pkExponent);
        Component nComponent = PanelUtil.searchComponentByName(parent, "n");
        String nStr = PanelUtil.getDataFromScrollPanel((JScrollPane) nComponent);
        try {
            String publicKeyDer = RsaUtil.geneneratePublicKey(nStr, publicExponent);
            Component pkDerComponent = PanelUtil.searchComponentByName(parent, "pkDER");
            ((JTextArea) ((JScrollPane) pkDerComponent).getViewport().getComponents()[0]).setText(publicKeyDer);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException ex) {
            //赋值
            Component resultComponent = PanelUtil.searchComponentByName(parent, "result");
            ((JTextArea) ((JScrollPane) resultComponent).getViewport().getComponents()[0]).setText(ex.getMessage());
        }

    }

    /**
     * 生成RSA密钥对
     *
     * @param  e 按钮事件
     */
    private void generateRsaKeyPair(ActionEvent e) {
        //获取密钥长度
        Container parent = ((JButton) e.getSource()).getParent();
        Component bits1 = PanelUtil.searchComponentByName(parent, "bits");
        String bitsString = PanelUtil.getDataFromScrollPanel((JScrollPane) bits1);
        int bits = Integer.parseInt(StringUtils.isEmpty(bitsString) ? "2048" : bitsString);
        //获取公钥指数
        Component pkExponent = PanelUtil.searchComponentByName(parent, "e");
        String publicExponent = PanelUtil.getDataFromScrollPanel((JScrollPane) pkExponent);
        try {
            Map<String, Object> keyMap = RsaUtil.generateKey(bits, publicExponent);
            //赋值
            Component pkDerComponent = PanelUtil.searchComponentByName(parent, "pkDER");
            Component pvDerComponent = PanelUtil.searchComponentByName(parent, "pvDER");
            ((JTextArea) ((JScrollPane) pkDerComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.PUBLIC_KEY)));
            ((JTextArea) ((JScrollPane) pvDerComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.PRIVATE_KEY)));
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException ex) {
            //赋值
            Component resultComponent = PanelUtil.searchComponentByName(parent, "result");
            ((JTextArea) ((JScrollPane) resultComponent).getViewport().getComponents()[0]).setText(ex.getMessage());
        }
    }

}
