package com.goiot.blesample.comm;


import com.goiot.blelib.data.BleDevice;

public interface Observer {

    void disConnected(BleDevice bleDevice);
}
