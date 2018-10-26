package com.young.wirelessserialport;

/**
 * Created by Zhipe on 2018/1/12.
 */

public class HexUtil {

    private final static String[] HEX = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return (HEX[iD1] + HEX[iD2]).toUpperCase();
    }

    public static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString().toUpperCase();
    }

    public static int byteToInteger(byte bByte) {
        if (bByte < 0) {
            return bByte + 256;
        }
        return bByte;
    }


}
