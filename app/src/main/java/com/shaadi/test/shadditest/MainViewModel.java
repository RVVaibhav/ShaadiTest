package com.shaadi.test.shadditest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MainViewModel extends BaseObservable {
    public ObservableBoolean isProgress;
    public GenericAdapter<ResultsItem, DataItemViewModel> genericDAdapter;
    private ObservableList<Disposable> compositeDisposable;
    private Observable<ResponseBody> responseBodyObservable;
    private ObservableList<ResultsItem> lists;
    private static final String TAG = "RouteDetailViewModel";
    DashBoardController controller;
    View view;

    public Context context;

    private GenericAdapter.OnItemClickListner listner = o -> {
        if (o instanceof ResultsItem) {
            ResultsItem model = (ResultsItem) o;
            ((MainActivity) Objects.requireNonNull(context)).openIntentActivity(model);


        }

       // (() Objects.requireNonNull(getFragment().getContext())).openNextFragmentFromItemClicked(AppFragmentEnum.TRANSPOTERSERVICES, (AddBranchResponse) o);
        Log.d(TAG, ": onItemClicked ");


    };


    public MainViewModel(Context context) {
        this.context = context;
        compositeDisposable = new ObservableArrayList<>();
        isProgress = new ObservableBoolean(false);
        lists = new ObservableArrayList<>();
        controller = new DashBoardController();
        this.view= view;
        downloadsComponent();
        generateRvContent();
    }

    private void generateRvContent() {
        DataItemViewModel itemModel = new DataItemViewModel();
        itemModel.setListener(listner);
        genericDAdapter = new GenericAdapter<>(lists, itemModel);
    }

    private void downloadsComponent() {
        isProgress.set(true);
        Observable<ResponseBody> observable = AppConstant.getController().getDataResponse();
        Disposable disposable = observable.flatMap((Function<ResponseBody, Observable<List<ResultsItem>>>) responseBody -> {
            String res = responseBody.string();
             controller = new DashBoardController();
            return Observable.just(controller.getAddDATA(res));
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, t -> showError(t.getMessage()));
        compositeDisposable.add(disposable);

    }

    private void onSuccess(List<ResultsItem> sResponses) {
        lists.clear();
        isProgress.set(false);
        lists.addAll(sResponses);
        System.out.println("messageData12345   "+lists.size());
        genericDAdapter.notifyDataSetChanged();

    }


    private void showError(String message) {
        isProgress.set(false);
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        System.out.println("messageData1234   "+message);
    }

   /* private void onSuccess(SResponse sResponses) {
      //  lists.clear();
        isProgress.set(false);
        lists.addAll(sResponses.getResults());
        System.out.println("setter"+lists.get(0).getEmail());
        genericAdapter.notifyDataSetChanged();

    }
*/
    @BindingAdapter(value = {"customDatas"}, requireAll = false)
    public static void designationLocationRecyclerview(RecyclerView recyclerView, GenericAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }
}
