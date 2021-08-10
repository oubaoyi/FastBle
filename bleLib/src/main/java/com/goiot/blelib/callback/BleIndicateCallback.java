package com.goiot.blelib.callback;


import com.goiot.blelib.exception.BleException;

public abstract class BleIndicateCallback extends BleBaseCallback{

    public abstract void onIndicateSuccess();

    public abstract void onIndicateFailure(BleException exception);

    public abstract void onCharacteristicChanged(byte[] data);
}
