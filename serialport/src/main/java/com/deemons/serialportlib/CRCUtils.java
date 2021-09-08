package com.deemons.serialportlib;

import java.nio.ByteBuffer;
import java.util.zip.CRC32;

public class CRCUtils {
    private static final ByteBuffer buffer = ByteBuffer.allocate(8);

    //byte 数组与 long 的相互转换
    public static byte[] longToBytes(long x) {
        buffer.putLong(0, x);
        return buffer.array();
    }

    //扔进来校验
    public static byte[] getCRCValues(byte[] b, int len) {
        CRC32 c = new CRC32();
        c.reset();//Resets CRC-32 to initial value.
        c.update(b, 0, len);//将数据丢入CRC32解码器
        return longToBytes(c.getValue());
    }

    //将16进制的字符串转成字符数组
    public static byte[] getHexBytes(String str) {
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }

    //16进制补零
    public static String getRightLengths(String hexs) {
        if (hexs.length() == 7) {
            return 0 + hexs;
        } else {
            return hexs;
        }
    }
}
