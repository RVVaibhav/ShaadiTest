package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture extends BaseObservable implements Parcelable {
	@SerializedName("thumbnail")
	@Expose
	private String thumbnail;
	@SerializedName("large")
	@Expose
	private String large;

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public void setLarge(String large) {
		this.large = large;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	@SerializedName("medium")
	@Expose
	private String medium;

	protected Picture(Parcel in) {
		thumbnail = in.readString();
		large = in.readString();
		medium = in.readString();
	}

	public static final Creator<Picture> CREATOR = new Creator<Picture>() {
		@Override
		public Picture createFromParcel(Parcel in) {
			return new Picture(in);
		}

		@Override
		public Picture[] newArray(int size) {
			return new Picture[size];
		}
	};

	public String getThumbnail(){
		return thumbnail;
	}

	public String getLarge(){
		return large;
	}

	public String getMedium(){
		return medium;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(thumbnail);
		parcel.writeString(large);
		parcel.writeString(medium);
	}
}
