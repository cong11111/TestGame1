package com.example.myapplication.global

import android.util.Log
import com.blankj.utilcode.util.SPUtils
import com.example.myapplication.BuildConfig
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

object RemoteConfigMgr {
    const val TAG = "RemoteConfigMgr"
    const val KEY_SHOW_AD = "show_ad"

    fun request() {
        val debugTime = if (BuildConfig.DEBUG) 600L else 3600L
        val mFirebaseRemoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings: FirebaseRemoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(debugTime)
            .build()
        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings)
        mFirebaseRemoteConfig.fetch()
            .addOnCompleteListener(object : OnCompleteListener<Void> {
                override fun onComplete(p0: Task<Void>) {
                    try {
                        mFirebaseRemoteConfig.activate()
                        mFirebaseRemoteConfig.fetch(0)
                        var showAdFlag = mFirebaseRemoteConfig.getBoolean(KEY_SHOW_AD)
                        if (App.mContext != null) {
                            SPUtils.getInstance().put(Constant.KEY_SHOW_AD_FLAG, showAdFlag)
                        }
                        Log.e(TAG, "showAdFlag : $showAdFlag")
                    } catch (e : Exception) {

                    }
                }

            })
    }
}