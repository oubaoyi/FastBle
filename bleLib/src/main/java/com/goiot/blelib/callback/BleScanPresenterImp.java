package com.goiot.blelib.callback;

import com.goiot.blelib.data.BleDevice;

public interface BleScanPresenterImp {

    void onScanStarted(boolean success);

    void onScanning(BleDevice bleDevice);

}
