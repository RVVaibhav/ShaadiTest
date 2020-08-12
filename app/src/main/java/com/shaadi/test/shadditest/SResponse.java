package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SResponse extends BaseObservable implements Parcelable {

	@SerializedName("results")
	@Expose

	private List<ResultsItem> results;

	public void setResults(List<ResultsItem> results) {
		this.results = results;
	}

	public SResponse() {

    }

	@SerializedName("info")
	@Expose
	@Embedded
	private Info info;

	protected SResponse(Parcel in) {
	}

	public static final Creator<SResponse> CREATOR = new Creator<SResponse>() {
		@Override
		public SResponse createFromParcel(Parcel in) {
			return new SResponse(in);
		}

		@Override
		public SResponse[] newArray(int size) {
			return new SResponse[size];
		}
	};

	public List<ResultsItem> getResults(){
		return results;
	}

	public Info getInfo(){
		return info;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
	}
}