package com.example.myapplication;


import android.os.Bundle;

import com.example.myapplication.ad.InterstitialAdMgr;
import com.example.myapplication.ad.RewardAdMgr;

import org.cocos2dx.javascript.AppActivity;
import org.cocos2dx.javascript.NMProxyAD;

public class BaseCocosActivity extends AppActivity {


    private InterstitialAdMgr mAdMgr;
    private RewardAdMgr mRewardAdMgr;

    @Override
    protected void onCreate(Bundle bundle) {
        NMProxyAD.addActivity(this);
        super.onCreate(bundle);
        mAdMgr = new InterstitialAdMgr();
        mRewardAdMgr = new RewardAdMgr();
        mAdMgr.preLoad(BaseCocosActivity.this);
    }

    public void showAd() {
        if (mAdMgr != null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (isFinishing() || isDestroyed()){
                        return;
                    }
                    mAdMgr.showAd(BaseCocosActivity.this);
                }
            });
        }
    }

    public void showRewardAd() {
        if (mAdMgr != null) {
            mRewardAdMgr.preload(this);
        }
    }

    @Override
    protected void onDestroy() {
        if (mAdMgr != null) {
            mAdMgr.onDestroy();
        }
        NMProxyAD.removeActivity(this);
        super.onDestroy();
    }
}
