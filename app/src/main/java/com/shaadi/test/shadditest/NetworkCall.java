package com.shaadi.test.shadditest;

import android.util.Log;

public final class NetworkCall {

    private static final String TAG = "NetworkCall";

    private static RetroController controller;
    private static boolean isTripCost= false;

    private NetworkCall(NetworkBuilder networkBuilder) {
     //   return Retro.getInstance().getControllerFuelCost( AppConstant.BASE_URL);
        controller = Retro.getInstance().getController( AppConstant.BASE_URL);

    }
    public static RetroController getController() {
        return controller;
    }

    public static final class NetworkBuilder {
        String token;


        public NetworkBuilder setHeader() {
//            token = Prefs.getString(AppConstant.TOKEN, "-1") + " " + MyApplication.getInstance().getAppToken();
            Log.d(TAG, "setHeader: " + token);
            return this;
        }

        public NetworkCall build() {
            return new NetworkCall(this);
        }
    }
}
