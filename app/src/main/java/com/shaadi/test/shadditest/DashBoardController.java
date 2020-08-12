package com.shaadi.test.shadditest;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DashBoardController {

    public DashBoardController() {

    }


    public List<ResultsItem> getAddDATA(String response) throws JSONException {
        List<ResultsItem> transportModels = new ArrayList<>();
        if (response != null && !TextUtils.isEmpty(response)) {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonarray = jsonObject.getJSONArray("results");
            Type listType = new TypeToken<ArrayList<ResultsItem>>(){}.getType();
            List<ResultsItem> allUserses =
                    new GsonBuilder().create().fromJson(jsonarray.toString(),listType);
            transportModels.addAll(allUserses);

          /*  Gson gson = new Gson();
            SResponse generalInfoObject = gson.fromJson(response,SResponse.class);
            transportModels.add(generalInfoObject);
          //  Prefs.putString(AppConstant.ADDb,new Gson().toJson(liveLocations1));*/
        }
        return transportModels;
    }
}
