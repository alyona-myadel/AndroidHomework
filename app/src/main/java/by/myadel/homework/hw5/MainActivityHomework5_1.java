package by.myadel.homework.hw5;


import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import by.myadel.homework.R;

public class MainActivityHomework5_1 extends AppCompatActivity {
    private ImageView imageView;
    private WifiManager manager;
    private boolean isBound = false;
    private MyServiceForWifi.MyBinder myBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hw5_1_activity_main);
        imageView = findViewById(R.id.hw5_1_image_view_wifi);
        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        registerReceiver(innerReceiver, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));
        bindService(new Intent(this, MyServiceForWifi.class), connection, BIND_AUTO_CREATE);
        Button changeStatus = findViewById(R.id.change_status_wi_fi_button);
        changeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBound) {
                    myBinder.getService().wifiChangeStatus();
                }
            }
        });
        visibleWifi();
    }

    private void visibleWifi() {
        if (manager.isWifiEnabled()) {
            changeImageToBlack();
        } else {
            changeImageToGray();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
        isBound = false;
        unregisterReceiver(innerReceiver);
    }

    private BroadcastReceiver innerReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            visibleWifi();
        }
    };

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyServiceForWifi.MyBinder) iBinder;
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBound = false;
        }
    };

    private void changeImageToGray() {
        Glide
                .with(MainActivityHomework5_1.this)
                .load(R.drawable.ic_wifi_gray)
                .into(imageView);

    }

    private void changeImageToBlack() {
        Glide
                .with(MainActivityHomework5_1.this)
                .load(R.drawable.ic_wifi_black)
                .into(imageView);
    }
}
