package com.example.myapplication;


import android.os.Bundle;

import com.example.myapplication.ad.InterstitialAdMgr;

import org.cocos2dx.javascript.AppActivity;
import org.cocos2dx.javascript.NMProxyAD;

public class BaseCocosActivity extends AppActivity {


    private InterstitialAdMgr mAdMgr;

    @Override
    protected void onCreate(Bundle bundle) {
        NMProxyAD.addActivity(this);
        super.onCreate(bundle);
        mAdMgr = new InterstitialAdMgr();
        mAdMgr.preLoad(BaseCocosActivity.this);
    }

    public void showAd() {
        if (mAdMgr != null) {
            mAdMgr.showAd(BaseCocosActivity.this);
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
