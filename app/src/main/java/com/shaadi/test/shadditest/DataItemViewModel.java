package com.shaadi.test.shadditest;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.squareup.picasso.Picasso;

public class DataItemViewModel extends BaseObservable implements ViewModel<ResultsItem> {
    public GenericAdapter.OnItemClickListner listener;
    // private AddBranchResponse rawmodel;
    public DataItemViewModel() {
        // placesName = new ObservableField<>();
    }

    @Override
    public int layoutId() {
        return R.layout.items_rv_data;
    }

    @Override
    public void setModel(ResultsItem o) {
        // this.rawmodel = o;
    }

    @BindingAdapter({"imgs_document"})
    public static void setImagesFile(CircleImageView imageView, String imgPath) {
      //  System.out.println("sdfg" + imgPath);
        Picasso.get().load(imgPath).fit().into(imageView);
        //  Picasso.get().load(f).fit().into(imageView);

    }


    public void setListener(GenericAdapter.OnItemClickListner listner) {
        this.listener = listner;
    }

    public void itemClicked(View view, ResultsItem model, int position) {
        if (listener != null && model != null) {
            listener.onItemClicked(model);
        }
    }


}
