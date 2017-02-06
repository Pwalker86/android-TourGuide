package com.example.android.tourguide;

import android.app.Application;

/**
 * Created by phil.walker on 2/6/17.
 */

public class MyApplication extends Application {
    private static int tabPosition = 0;

    public static int getTabPosition() {
        return tabPosition;
    }

    public static void setTabPosition(int newPosition){
        tabPosition = newPosition;
    }

}
