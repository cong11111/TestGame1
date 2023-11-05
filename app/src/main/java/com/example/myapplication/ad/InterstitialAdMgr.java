package com.example.myapplication.ad;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.blankj.utilcode.util.SPUtils;
import com.example.myapplication.global.Constant;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class InterstitialAdMgr {
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "InterstitialAdMgr";

    public void preLoad(Activity activity) {
        boolean showFlag = SPUtils.getInstance().getBoolean(Constant.KEY_SHOW_AD_FLAG);
        if (!showFlag) {
            return;
        }
        preLoad(activity, false);
    }

    private void preLoad(Activity activity, boolean showFlag) {
        if (mInterstitialAd != null) {
            return;
        }
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, AdConfig.INTERSTITIAL_AD_ID, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        if (showFlag) {
                            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                                return;
                            }
                            mInterstitialAd.show(activity);
                        }
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });
    }

    public void showAd(Activity activity) {
        boolean showFlag = SPUtils.getInstance().getBoolean(Constant.KEY_SHOW_AD_FLAG);
        if (!showFlag) {
            return;
        }
        if (mInterstitialAd == null) {
            preLoad(activity, true);
        } else {
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdClicked() {
                    // Called when a click is recorded for an ad.
                    Log.d(TAG, "Ad was clicked.");
                }

                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    // Set the ad reference to null so you don't show the ad a second time.
                    Log.d(TAG, "Ad dismissed fullscreen content.");
                    mInterstitialAd = null;
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    // Called when ad fails to show.
                    Log.e(TAG, "Ad failed to show fullscreen content.");
                    mInterstitialAd = null;
                }

                @Override
                public void onAdImpression() {
                    // Called when an impression is recorded for an ad.
                    Log.d(TAG, "Ad recorded an impression.");
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    Log.d(TAG, "Ad showed fullscreen content.");
                }
            });
            mInterstitialAd.show(activity);
        }
    }

    public void onDestroy() {
        if (mInterstitialAd != null) {
            mInterstitialAd = null;
        }
    }

}
