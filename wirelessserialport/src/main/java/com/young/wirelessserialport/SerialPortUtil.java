package com.young.wirelessserialport;

/**
 * Created by Zhipe on 2018/3/23.
 */

public class SerialPortUtil {

    public static String[] getSerialPortPath() {
        SerialPortFinder serialPortFinder = new SerialPortFinder();
        String[] allDevicesPath = serialPortFinder.getAllDevicesPath();
        return allDevicesPath;
    }
}
