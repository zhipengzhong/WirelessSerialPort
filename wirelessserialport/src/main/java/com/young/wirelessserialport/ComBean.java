package com.young.wirelessserialport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhipeng
 */
public class ComBean {
    public byte[] bRec = null;
    public byte[] bData = null;
    public int mAddress;
    public int mTarget;
    public int mLen;
    public byte[] mHead = new byte[2];
    public byte mCommand;
    public String sRecTime = "";
    public String sComPort = "";

    public ComBean(String sPort, byte[] buffer) {
        sComPort = sPort;
        mLen = HexUtil.byteToInteger(buffer[2]);
        mTarget = HexUtil.byteToInteger(buffer[3]);
        mAddress = HexUtil.byteToInteger(buffer[4]);
        mCommand = buffer[5];
        bData = new byte[buffer.length];
        bRec = new byte[buffer.length - 6];
        System.arraycopy(buffer, 0, mHead, 0, 2);
        System.arraycopy(buffer, 0, bData, 0, buffer.length);
        System.arraycopy(buffer, 6, bRec, 0, buffer.length - 6);
        SimpleDateFormat sDateFormat = new SimpleDateFormat("hh:mm:ss");
        sRecTime = sDateFormat.format(new Date());
    }
}