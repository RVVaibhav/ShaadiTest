package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info extends BaseObservable implements Parcelable {
	@SerializedName("seed")
	@Expose
	private String seed;
	@SerializedName("page")
	@Expose
	private int page;
	@SerializedName("results")
	@Expose
	private int results;
	@SerializedName("version")
	@Expose
	private String version;

	public void setSeed(String seed) {
		this.seed = seed;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	protected Info(Parcel in) {
		seed = in.readString();
		page = in.readInt();
		results = in.readInt();
		version = in.readString();
	}

	public static final Creator<Info> CREATOR = new Creator<Info>() {
		@Override
		public Info createFromParcel(Parcel in) {
			return new Info(in);
		}

		@Override
		public Info[] newArray(int size) {
			return new Info[size];
		}
	};

	public String getSeed(){
		return seed;
	}

	public int getPage(){
		return page;
	}

	public int getResults(){
		return results;
	}

	public String getVersion(){
		return version;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(seed);
		parcel.writeInt(page);
		parcel.writeInt(results);
		parcel.writeString(version);
	}
}
