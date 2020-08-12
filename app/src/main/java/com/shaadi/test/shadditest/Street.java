package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Street extends BaseObservable implements Parcelable {
	@SerializedName("number")
	@Expose
	private int number;
	@SerializedName("name")
	@Expose
	private String name;

	protected Street(Parcel in) {
		number = in.readInt();
		name = in.readString();
	}

	public static final Creator<Street> CREATOR = new Creator<Street>() {
		@Override
		public Street createFromParcel(Parcel in) {
			return new Street(in);
		}

		@Override
		public Street[] newArray(int size) {
			return new Street[size];
		}
	};

	public int getNumber(){
		return number;
	}

	public String getName(){
		return name;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeInt(number);
		parcel.writeString(name);
	}
}
