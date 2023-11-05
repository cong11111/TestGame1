package org.cocos2dx.javascript;

import android.app.Activity;
import android.util.Log;

import com.example.myapplication.BaseCocosActivity;

import java.util.HashSet;
import java.util.Iterator;

public class NMProxyAD {
//    org/cocos2dx/javascript/NMProxyAD
    private static HashSet<Activity> mSet = new HashSet<>();

    public static void addActivity(Activity activity) {
        mSet.add(activity);
    }

    public static void removeActivity(Activity activity) {
        mSet.add(activity);
    }

    public static void initByScript() {
        Log.e("Test", "initByScript");
    }

    public static void ShowBanner() {
        Log.e("Test", "ShowBanner");
    }

    public static void HideBanner() {
        Log.e("Test", "HideBanner");
    }

    public static void DestroyBanner() {
        Log.e("Test", "DestroyBanner");
    }

    public static void IsInterstitialAvailable() {
        Log.e("Test", "IsInterstitialAvailable");
    }

    public static void LoadInterstitial() {
        Log.e("Test", "LoadInterstitial");
        Activity curActivity = getCurActivity();
        if (curActivity != null && !curActivity.isDestroyed()  && !curActivity.isFinishing()) {
            if (curActivity instanceof BaseCocosActivity) {
                Log.e("Test", "LoadInterstitial 3");
                BaseCocosActivity cocosActivity = (BaseCocosActivity) curActivity;
                cocosActivity.showAd();
            }
        }
    }

//    callback: Function, blockerPrefabKey: string, blockDuration: number
    public static void ShowInterstitial() {
//        Activity curActivity = getCurActivity();
//        if (curActivity != null && !curActivity.isDestroyed()  && !curActivity.isFinishing()) {
//            if (curActivity instanceof BaseCocosActivity) {
//                BaseCocosActivity cocosActivity = (BaseCocosActivity) curActivity;
//                cocosActivity.showAd();
//            }
//        }
        Log.e("Test", "ShowInterstitial");
    }

    public static void ShowInterstitialWithBlocker() {
        Activity curActivity = getCurActivity();
        if (curActivity != null && !curActivity.isDestroyed()  && !curActivity.isFinishing()) {
            if (curActivity instanceof BaseCocosActivity) {
                BaseCocosActivity cocosActivity = (BaseCocosActivity) curActivity;
                cocosActivity.showAd();
            }
        }
        Log.e("Test", "ShowInterstitial");
    }



    public static void IsRewardedVideoAvailable() {
        Log.e("Test", "IsRewardedVideoAvailable");
    }

    public static void ShowRewardedVideo() {
        Log.e("Test", "ShowRewardedVideo");
    }


//protected IsInterstitialAvailableImpl(): boolean { return jsb.reflection.callStaticMethod(NMPROXYAD_CLASS_NAME, "IsInterstitialAvailable", "()Z") }
//protected LoadInterstitialImpl(): void { jsb.reflection.callStaticMethod(NMPROXYAD_CLASS_NAME, "LoadInterstitial", "()V"); }
//protected ShowInterstitialImpl(handler: InterstitialCallback): void {
//        jsb.reflection.callStaticMethod(NMPROXYAD_CLASS_NAME, "ShowInterstitial", "()V");
//        }
//protected IsRewardedVideoAvailableImpl(): boolean {
//        return jsb.reflection.callStaticMethod(NMPROXYAD_CLASS_NAME, "IsRewardedVideoAvailable", "()Z");
//        }
//protected ShowRewardedVideoImpl(callback: (type: EInternalRewardedVideo, isRewared: boolean) => void): void {
//        jsb.reflection.callStaticMethod(NMPROXYAD_CLASS_NAME, "ShowRewardedVideo", "()V");
//        }
//        }

    private static Activity getCurActivity() {
        Activity activity = null;
        Iterator<Activity> iterator = mSet.iterator();
        while (iterator.hasNext()) {
            Activity next = iterator.next();
            if (next.isFinishing() || next.isDestroyed()){
                break;
            }
            activity = next;
            break;
        }
        return activity;
    }
}
