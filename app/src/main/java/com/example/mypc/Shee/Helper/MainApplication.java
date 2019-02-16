package com.example.mypc.Shee.Helper;

import android.app.Application;
import android.content.Context;

/**
 * Created by my pc on 30-Mar-18.
 */

public class MainApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
