package com.example.myapplication.global;

import android.app.Application;

import com.example.myapplication.BuildConfig;
import com.example.myapplication.ad.AppOpenManager;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;

public class App extends Application {

    private AppOpenManager openManager;

    @Override
    public void onCreate() {
        super.onCreate();
        openManager = new AppOpenManager(this);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        if (BuildConfig.DEBUG) {
            RequestConfiguration.Builder configuration = new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("AA173640CF0F2070C2A45ACBC34A3819"));
            MobileAds.setRequestConfiguration(configuration.build());
        }
    }

}
