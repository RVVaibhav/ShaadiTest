package com.shaadi.test.shadditest;

public class AppConstant {

    public static final String BASE_URL="https://randomuser.me";
    public static final String APP_DB = "APP_DB";
    public static final String USER_DATA = "USER_DATA";
    public static final String PREF_NAME ="PREF_NAME" ;
///api/?results=10

    public static RetroController getController() {
        return NetworkCall.getController();
    }
}
