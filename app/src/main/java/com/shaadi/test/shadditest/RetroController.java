package com.shaadi.test.shadditest;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface RetroController {

    @GET("/api/?results=10")
    Observable<ResponseBody> getDataResponse();
}
