package com.mochi.secret;

import com.mochi.common.enumutil.ResponseEnum;
import com.mochi.common.exception.BusinessException;
import com.mochi.common.util.StringUtil;

public class HashUtil {

    /**
     * ANSI X9.9MAC算法 <br/>
     * (1) ANSI X9.9MAC算法只使用单倍长密钥。 <br/>
     * (2)  MAC数据先按8字节分组，表示为D0～Dn，如果Dn不足8字节时，尾部以字节00补齐。 <br/>
     * (3) 用MAC密钥加密D0，加密结果与D1异或作为下一次的输入。 <br/>
     * (4) 将上一步的加密结果与下一分组异或，然后再用MAC密钥加密。 <br/>
     * (5) 直至所有分组结束，取最后结果的左半部作为MAC。 <br/>
     * 采用x9.9算法计算MAC (Count MAC by ANSI-x9.9).
     *
     * @param key  8字节密钥数据
     * @param data 待计算的缓冲区
     */
    public static byte[] x99Hash(byte[] key, byte[] data) {
        final int dataLength = data.length;
        final int lastLength = data.length % 8;
        final int lastBlockLength = lastLength == 0 ? 8 : lastLength;
        final int blockCount = dataLength / 8 + (lastLength > 0 ? 1 : 0);

        //拆分数据
        byte[][] dataBlock = new byte[blockCount][8];
        for (int i = 0; i < blockCount; i++) {
            int copyLength = i == blockCount - 1 ? lastBlockLength : 8;
            System.arraycopy(data, i * 8, dataBlock[i], 0, copyLength);
        }
        byte[] desXor = new byte[8];
        for (int i = 0; i < blockCount; i++) {
            byte[] tXor = StringUtil.xor(desXor, dataBlock[i]);
            desXor = DesUtil.encryptECB(key, tXor);
        }
        return desXor;
    }

    /**
     * 采用ANSI x9.19算法计算MAC (Count MAC by ANSI-x9.19).<br/>
     * 将ANSI X9.9的结果做如下计算<br/>
     * (6) 用MAC密钥右半部解密(5)的结果。 <br/>
     * (7) 用MAC密钥左半部加密(6)的结果。<br/>
     * (8) 取(7)的结果的左半部作为MAC。<br/>
     *
     * @param key  16字节密钥数据
     * @param data 待计算的缓冲区
     */
    public static byte[] x919Hash(byte[] key, byte[] data) {
        if (key == null || data == null) {
            return null;
        }

        if (key.length != 16) {
            throw new BusinessException(ResponseEnum.PB_0004.getRespCode(), ResponseEnum.PB_0004.getRespMsg());
        }

        byte[] keyLeft = new byte[8];
        byte[] keyRight = new byte[8];
        System.arraycopy(key, 0, keyLeft, 0, 8);
        System.arraycopy(key, 8, keyRight, 0, 8);

        byte[] result99 = x99Hash(keyLeft, data);

        byte[] resultTemp = DesUtil.decryptECB(keyRight, result99);
        return DesUtil.encryptECB(resultTemp, keyLeft);
    }
}
