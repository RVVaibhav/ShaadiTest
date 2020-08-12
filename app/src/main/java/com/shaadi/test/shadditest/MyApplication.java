package com.shaadi.test.shadditest;

import android.app.Application;

import androidx.constraintlayout.widget.Constraints;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

public class MyApplication extends Application {


    private static String TAG = "MyApplication";

    private static MyApplication mInstance;
    public boolean isLoggingNeeded = true;
    private static final String PREF_NAME= AppConstant.PREF_NAME;



    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    private String hashKey;


    public static MyApplication getInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
       // Fabric.with(this, new Crashlytics());
//        Fabric.with(this, new Crashlytics());
        mInstance = this;
        mInstance.initPref();
//        mInstance.initLeakCanary();
        //Stetho.initializeWithDefaults(this);
       // AppSignatureHelper appSignatureHashHelper = new AppSignatureHelper(this);
       // setHashKey(appSignatureHashHelper.getAppSignatures().get(0));
        mInstance.initNetworkCall();
        mInstance.initPicassoLog();
        mInstance.initTimberLog();
        //   setUpWorkManager();
        setUpWorkManagerNoPeriodic();

    }

    private void initTimberLog() {
        if (BuildConfig.DEBUG) {
          //  Timber.plant(new Timber.DebugTree());

        }
    }


    private void initLeakCanary() {

    }

    private void initPicassoLog() {
     //   Picasso.get().setLoggingEnabled(true);
    }


    public RetroController initNetworkCall() {
        new NetworkCall.NetworkBuilder().build();
        return NetworkCall.getController();
    }


    private void initPref() {
        new Prefs.Builder()
                .setContext(this)
                .setMode(MODE_PRIVATE)
                .setPrefsName(PREF_NAME)
                .setUseDefaultSharedPreference(false)
                .build();
    }


    private void setUpWorkManagerNoPeriodic() {

     /*   Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(false)
                .build();
        requestWork = new OneTimeWorkRequest.Builder(DownloadWorkMangerNonPeriodic.class)
                .setConstraints(constraints)
                .build();


        enquequeWorkManagerNoPeriodic();*/

    }

  /*  private void enquequeWorkManagerNoPeriodic() {
        if (request != null)
            WorkManager.getInstance().enqueue(request);
        if (!Prefs.getBoolean(AppConstant.isDownloadFirst, false)) {
            if (requestWork != null)
                WorkManager.getInstance().enqueue(requestWork);
        }
    }*/


 /*   private void setUpWorkManager() {

//        Data dataBreath = new Data.Builder()
//                .putString(AppConstant.isBreath, AppConstant.isBreath)
//                .build();
        Constraints constraints = new Constraints.Builder()
                .setRequiresDeviceIdle(false)
                .build();

        request = new PeriodicWorkRequest.Builder(DownloadWorkManger.class, 1, TimeUnit.DAYS)
                .setConstraints(constraints)
                .build();
    }*/


   /* public RegistrationServerModel getUserRegistrationModel() {

        return new Gson().fromJson(Prefs.getString(AppConstant.USER_PROFILE), RegistrationServerModel.class);

    }*/

    /*public UserProfileModel getUserSRegistrationModel() {

        return new Gson().fromJson(Prefs.getString(AppConstant.USER), UserProfileModel.class);

    }*/

   /* public AddBranchResponse getTradd() {

        return new Gson().fromJson(Prefs.getString(AppConstant.ADDb), AddBranchResponse.class);

    }*/
}