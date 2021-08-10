package com.goiot.blelib.callback;


import com.goiot.blelib.exception.BleException;

public abstract class BleRssiCallback extends BleBaseCallback{

    public abstract void onRssiFailure(BleException exception);

    public abstract void onRssiSuccess(int rssi);

}