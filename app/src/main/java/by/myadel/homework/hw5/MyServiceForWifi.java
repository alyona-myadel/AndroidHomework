package by.myadel.homework.hw5;


import android.app.Service;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyServiceForWifi extends Service {
    private WifiManager manager;

    @Override
    public void onCreate() {
        super.onCreate();
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        MyBinder myBinder = new MyBinder();
        return myBinder;
    }

    public void wifiChangeStatus() {
        manager.setWifiEnabled(!manager.isWifiEnabled());
    }

    class MyBinder extends Binder {
        MyServiceForWifi getService() {
            return MyServiceForWifi.this;
        }
    }
}
