package com.shaadi.test.shadditest;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.gson.Gson;
import com.shaadi.test.shadditest.databinding.ActivityCandidateProfileBinding;
import com.shaadi.test.shadditest.databinding.ActivityCandidateProfilesBinding;

public class CandidateProfile extends AppCompatActivity {

    ResultsItem resultsItem ;
    ActivityCandidateProfilesBinding binding;
    private CandidateViewModel model;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_candidate_profile);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_candidate_profiles);
        setUpView();
    }

    private void setUpView() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        resultsItem = new Gson().fromJson(Prefs.getString(AppConstant.USER_DATA), ResultsItem.class);
       // resultsItem =  Prefs.getString(AppConstant.USER_DATA);
        model = new CandidateViewModel(this,resultsItem);
        binding.setViewModel(model);

    }

}
