package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;

import org.cocos2dx.javascript.AppActivity;

import java.util.Arrays;

public class GameActivity extends AppActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (BuildConfig.DEBUG) {
            RequestConfiguration.Builder configuration = new RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList("AA173640CF0F2070C2A45ACBC34A3819"));
            MobileAds.setRequestConfiguration(configuration.build());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mAdView == null) {
            tryAddAdView();
        }
    }

    private void tryAddAdView() {
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.BANNER);
//        mAdView.setAdUnitId("ca-app-pub-2208951185660270/6236011992");
        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
//        View view = new View(this);
//        view.setBackgroundColor(Color.RED);
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mAdlayout = findViewById(R.id.fl_content_ad);
        mAdlayout.addView(mAdView, layoutParams);
//        Log.e("Test", " test 111111111111111111111111");
        loadAdView();
    }

    private void loadAdView(){
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                Log.e("Test", "" +adError.getMessage());
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });
    }

    private void loadAd() {
        AdLoader adLoader = new AdLoader.Builder(GameActivity.this, "ca-app-pub-3940256099942544/2247696110")
                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(NativeAd nativeAd) {
                        // Show the ad.
                    }
                })
                .withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(LoadAdError adError) {
                        // Handle the failure by logging, altering the UI, and so on.
                    }
                })
                .withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .build())
                .build();
    }

//    private void loadAdView(){
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//    }
}
