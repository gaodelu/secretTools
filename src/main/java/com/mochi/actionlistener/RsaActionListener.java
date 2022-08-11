package com.mochi.actionlistener;

import com.mochi.common.enumutil.Constants;
import com.mochi.common.enumutil.ResponseEnum;
import com.mochi.common.exception.BusinessException;
import com.mochi.common.util.PanelUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.lang3.StringUtils;
import com.mochi.secret.RsaUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

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
                getDerPv(e);
                break;
            case "分解DER公钥":
                decomposeDerpk(e);
                break;
            case "分解DER私钥":
                decomposeDerpv(e);
                break;
            case "公钥加密（PKCS1）": // TODO: 2022/8/11
                decomposeDerpv(e);
                break;
            case "公钥解密（PKCS1）": // TODO: 2022/8/11
                decomposeDerpv(e);
                break;
            case "公钥加密": // TODO: 2022/8/11
                decomposeDerpv(e);
                break;
            case "公钥解密": // TODO: 2022/8/11
                decomposeDerpv(e);
                break;
            default:
                throw new BusinessException(ResponseEnum.PB_0001.getRespCode(), ResponseEnum.PB_0001.getRespMsg());
        }
    }

    /**
     * 分解DER私钥
     *
     * @param e
     */
    private void decomposeDerpv(ActionEvent e) {
        Container parent = ((JButton) e.getSource()).getParent();
        Component pvCom = PanelUtil.searchComponentByName(parent, "pvDER");
        String pvDer = PanelUtil.getDataFromScrollPanel((JScrollPane) pvCom);
        try {
            Map<String, Object> keyMap = RsaUtil.decomposeDerPv(pvDer);
            Component nComponent = PanelUtil.searchComponentByName(parent, "n");
            Component dComponent = PanelUtil.searchComponentByName(parent, "d");
            Component pComponent = PanelUtil.searchComponentByName(parent, "p");
            Component qComponent = PanelUtil.searchComponentByName(parent, "q");
            Component dpComponent = PanelUtil.searchComponentByName(parent, "dp");
            Component dqComponent = PanelUtil.searchComponentByName(parent, "dq");
            Component invqpComponent = PanelUtil.searchComponentByName(parent, "invqp");
            Component eComponent = PanelUtil.searchComponentByName(parent, "e");
            ((JTextArea) ((JScrollPane) nComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.N)));
            ((JTextArea) ((JScrollPane) dComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.D)));
            ((JTextArea) ((JScrollPane) pComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.P)));
            ((JTextArea) ((JScrollPane) qComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.Q)));
            ((JTextArea) ((JScrollPane) dpComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.D_P)));
            ((JTextArea) ((JScrollPane) dqComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.D_Q)));
            ((JTextArea) ((JScrollPane) invqpComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.INV_Q_P)));
            ((JTextArea) ((JScrollPane) eComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.E)));
        } catch (NoSuchAlgorithmException | DecoderException | InvalidKeySpecException ex) {
            //赋值
            Component resultComponent = PanelUtil.searchComponentByName(parent, "result");
            ((JTextArea) ((JScrollPane) resultComponent).getViewport().getComponents()[0]).setText(ex.getMessage());
        }


    }

    /**
     * 合成DER私钥
     *
     * @param e
     */
    private void getDerPv(ActionEvent e) {
        Container parent = ((JButton) e.getSource()).getParent();
        Component nComponent = PanelUtil.searchComponentByName(parent, "n");
        String n = PanelUtil.getDataFromScrollPanel((JScrollPane) nComponent);
        Component dComponent = PanelUtil.searchComponentByName(parent, "d");
        String d = PanelUtil.getDataFromScrollPanel((JScrollPane) dComponent);
        Component pComponent = PanelUtil.searchComponentByName(parent, "p");
        String p = PanelUtil.getDataFromScrollPanel((JScrollPane) pComponent);
        Component qComponent = PanelUtil.searchComponentByName(parent, "q");
        String q = PanelUtil.getDataFromScrollPanel((JScrollPane) qComponent);
        Component dpComponent = PanelUtil.searchComponentByName(parent, "dp");
        String dp = PanelUtil.getDataFromScrollPanel((JScrollPane) dpComponent);
        Component dqComponent = PanelUtil.searchComponentByName(parent, "dq");
        String dq = PanelUtil.getDataFromScrollPanel((JScrollPane) dqComponent);
        Component invqpComponent = PanelUtil.searchComponentByName(parent, "invqp");
        String invqp = PanelUtil.getDataFromScrollPanel((JScrollPane) invqpComponent);
        Component eComponent = PanelUtil.searchComponentByName(parent, "e");
        String eM = PanelUtil.getDataFromScrollPanel((JScrollPane) eComponent);
        try {
            String privateKey = RsaUtil.geneneratePrivateKey(n, p, q, d, eM, dp, dq, invqp);
            Component pvComponent = PanelUtil.searchComponentByName(parent, "pvDER");
            ((JTextArea) ((JScrollPane) pvComponent).getViewport().getComponents()[0]).setText(privateKey);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | InvalidKeyException ex) {
            ex.printStackTrace();
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
     * @param e 按钮事件
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
     * @param e 按钮事件
     */
    private void generateRsaKeyPair(ActionEvent e) {
        //获取密钥长度
        Container parent = ((JButton) e.getSource()).getParent();
        Component bits1 = PanelUtil.searchComponentByName(parent, "bits");
        String bitsString = PanelUtil.getDataFromScrollPanel((JScrollPane) bits1);
        int bits = Integer.parseInt(StringUtils.isEmpty(bitsString) ? "2048" : bitsString);
        //获取公钥指数
        Component pkExponent = PanelUtil.searchComponentByName(parent, "e");
        String publicExponent = StringUtils.isEmpty(PanelUtil.getDataFromScrollPanel((JScrollPane) pkExponent)) ? "010001" : PanelUtil.getDataFromScrollPanel((JScrollPane) pkExponent);
        try {
            Map<String, Object> keyMap = RsaUtil.generateKey(bits, publicExponent);
            //赋值
            Component pkDerComponent = PanelUtil.searchComponentByName(parent, "pkDER");
            Component pvDerComponent = PanelUtil.searchComponentByName(parent, "pvDER");
            Component nComponent = PanelUtil.searchComponentByName(parent, "n");
            Component dComponent = PanelUtil.searchComponentByName(parent, "d");
            Component pComponent = PanelUtil.searchComponentByName(parent, "p");
            Component qComponent = PanelUtil.searchComponentByName(parent, "q");
            Component dpComponent = PanelUtil.searchComponentByName(parent, "dp");
            Component dqComponent = PanelUtil.searchComponentByName(parent, "dq");
            Component invqpComponent = PanelUtil.searchComponentByName(parent, "invqp");
            Component eComponent = PanelUtil.searchComponentByName(parent, "e");
            ((JTextArea) ((JScrollPane) pkDerComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.PUBLIC_KEY)));
            ((JTextArea) ((JScrollPane) pvDerComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.PRIVATE_KEY)));
            ((JTextArea) ((JScrollPane) nComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.N)));
            ((JTextArea) ((JScrollPane) dComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.D)));
            ((JTextArea) ((JScrollPane) pComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.P)));
            ((JTextArea) ((JScrollPane) qComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.Q)));
            ((JTextArea) ((JScrollPane) dpComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.D_P)));
            ((JTextArea) ((JScrollPane) dqComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.D_Q)));
            ((JTextArea) ((JScrollPane) invqpComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.INV_Q_P)));
            ((JTextArea) ((JScrollPane) eComponent).getViewport().getComponents()[0]).setText(String.valueOf(keyMap.get(Constants.E)));
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException ex) {
            //赋值
            Component resultComponent = PanelUtil.searchComponentByName(parent, "result");
            ((JTextArea) ((JScrollPane) resultComponent).getViewport().getComponents()[0]).setText(ex.getMessage());
        }
    }

}
