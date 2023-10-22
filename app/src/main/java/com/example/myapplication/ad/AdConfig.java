package com.example.myapplication.ad;

import com.example.myapplication.global.Constant;

public class AdConfig {

    private static class BannerKey {
        private static String RELEASE_AD_ID = "ca-app-pub-2208951185660270/6236011992";
        private static String TEST_AD_ID = "ca-app-pub-3940256099942544/6300978111";
    }


    public static String BANNER_AD_ID =
            Constant.NEED_BUILD_AAB ? BannerKey.RELEASE_AD_ID : BannerKey.TEST_AD_ID;

    private static class InterstitialKey {
        private static String RELEASE_AD_ID = "ca-app-pub-2208951185660270/6236011992";
        private static String TEST_AD_ID = "ca-app-pub-3940256099942544/1033173712";
    }
    public static String INTERSTITIAL_AD_ID =
            Constant.NEED_BUILD_AAB ? InterstitialKey.RELEASE_AD_ID : InterstitialKey.TEST_AD_ID;

    private static class AppOpenKey {
        private static String RELEASE_AD_ID = "ca-app-pub-2208951185660270/4939220115";
        private static String TEST_AD_ID = "ca-app-pub-3940256099942544/1033173712";
    }
    public static String APP_OPEN_AD_ID =
            Constant.NEED_BUILD_AAB ? AppOpenKey.RELEASE_AD_ID : AppOpenKey.TEST_AD_ID;

}
