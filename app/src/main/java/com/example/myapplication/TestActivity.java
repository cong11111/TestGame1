package com.example.myapplication;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;

import org.cocos2dx.javascript.AppActivity;
import org.cocos2dx.javascript.SDKWrapper;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;

public class TestActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

    }

    @Override
    protected void onResume() {
        super.onResume();
        tryAddAdView();
    }

//    @Override
//    public Cocos2dxGLSurfaceView onCreateView() {
//        Cocos2dxGLSurfaceView var10000 = new Cocos2dxGLSurfaceView(this);
//        var10000.setEGLConfigChooser(5, 6, 5, 0, 16, 8);
//        var10000.setZOrderOnTop(true);
//        SDKWrapper.getInstance().setGLSurfaceView(var10000, this);
//        return var10000;
//    }

    private void tryAddAdView() {
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2208951185660270/6236011992");
        mFrameLayout.addView(adView);
    }

    private void loadAd() {
        AdLoader adLoader = new AdLoader.Builder(TestActivity.this, "ca-app-pub-3940256099942544/2247696110")
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
}
