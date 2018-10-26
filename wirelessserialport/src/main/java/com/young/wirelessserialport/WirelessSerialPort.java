package com.young.wirelessserialport;

import java.io.IOException;
import java.security.InvalidParameterException;

/**
 * Created by Zhipe on 2018/1/11.
 */

public class WirelessSerialPort extends SerialHelper {

    private OnReceiveListener mListener;

    public WirelessSerialPort() {
    }

    public WirelessSerialPort(String sPort) {
        super(sPort);
    }

    public WirelessSerialPort(String sPort, String sBaudRate) {
        super(sPort, sBaudRate);
    }

    public WirelessSerialPort(String sPort, String sBaudRate, OnReceiveListener listener) {
        super(sPort, sBaudRate);
        mListener = listener;
    }

    @Override
    protected void onDataReceived(ComBean comRecData) {
        if (mListener != null) {
            mListener.onReceive(comRecData);
        }
    }

    public WirelessSerialPort openPort() {
        try {
            super.open();
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void close() {
        super.close();
    }

    @Override
    public void send(byte[] bOutArray) {
        super.send(bOutArray);
    }

    @Override
    public void sendHex(String sHex) {
        super.sendHex(sHex);
    }

    @Override
    public void sendTxt(String sTxt) {
        super.sendTxt(sTxt);
    }

    public interface OnReceiveListener {
        void onReceive(ComBean comBean);
    }
}
