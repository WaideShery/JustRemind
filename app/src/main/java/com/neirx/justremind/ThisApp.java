package com.neirx.justremind;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Waide Shery on 13.10.2017.
 */

public class ThisApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}