package com.goiot.blesample.comm;


import com.goiot.blelib.data.BleDevice;

public interface Observable {

    void addObserver(Observer obj);

    void deleteObserver(Observer obj);

    void notifyObserver(BleDevice bleDevice);
}
