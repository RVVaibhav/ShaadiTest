package com.shaadi.test.shadditest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.google.gson.Gson;
import com.shaadi.test.shadditest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setModelView();

    }

    private void setModelView() {
        model = new MainViewModel(this);
        binding.setViewModel(model);
    }

    public void openIntentActivity(ResultsItem model) {
        Intent intent = new Intent(this, CandidateProfile.class);
        Prefs.putString(AppConstant.USER_DATA, new Gson().toJson(model));
       // intent.putExtra(AppConstant.USER_DATA,model);
        startActivity(intent);

    }
}
