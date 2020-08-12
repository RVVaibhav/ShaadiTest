/*
package com.shaadi.test.shadditest;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DashRepository  extends AndroidViewModel {


  */
/*  TableSRResponseDao dao;
    public DashRepository(@NonNull Application application) {
        super(application);
        AppDatabase database= AppDatabase.getDatabase(application);
        dao=database.getDashRepository();
    }

    public void insert(List<SResponse> servicesModels){
        Observable.fromIterable(servicesModels)
                .flatMap(coin -> Observable.just(saveCoin(coin)))
                .subscribeOn(Schedulers.io())
                .subscribe();


    }

    public void insert(SResponse notifications){
        Observable.just(notifications)
                .flatMap(coin -> Observable.just(saveCoin(coin)))
                .subscribeOn(Schedulers.io())
                .subscribe();


    }*//*



   */
/* private Long saveCoin(SResponse coin) {
        // Timber.d("saveUser: " + new Gson().toJson(dao.getCityModelByID(notifcation.getId())));
        return dao.insertTestQ(coin)[0];
    }

    public void clearAll() {
        dao.clearAll();
    }

    public LiveData<List<SResponse>> getTestQ() {
        return dao.getTestQ();
    }*//*



}
*/
