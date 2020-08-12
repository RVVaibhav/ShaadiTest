package com.shaadi.test.shadditest;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.squareup.picasso.Picasso;

public class CandidateViewModel extends BaseObservable {
   public ObservableField<String>name;
    public ObservableField<String>city;
    public ObservableField<String>number;
    public ResultsItem resultsItem;
    public  Context context;

    public CandidateViewModel(CandidateProfile candidateProfile, ResultsItem resultsItem) {
        this.context = candidateProfile;
        this.resultsItem = resultsItem;
    }

    @BindingAdapter({"img_home_path_document"})
    public static void setImagesFile(CircleImageView imageView, String imgPath) {
        System.out.println("sdfg"+imgPath);
        Picasso.get().load(imgPath).fit().into(imageView);
        //  Picasso.get().load(f).fit().into(imageView);

    }


    public void itemClickedDC(View view, ResultsItem model) {
        Toast.makeText(context,"Decline Request!", Toast.LENGTH_SHORT).show();
    }

    public void itemClickedAc(View view, ResultsItem model) {
        Toast.makeText(context,"Accept Request!", Toast.LENGTH_SHORT).show();

    }
}
