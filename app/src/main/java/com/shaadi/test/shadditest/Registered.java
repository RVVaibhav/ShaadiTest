package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Registered extends BaseObservable implements Parcelable {
	@SerializedName("date")
	@Expose
	private String date;

	public void setDate(String date) {
		this.date = date;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static Creator<Registered> getCREATOR() {
		return CREATOR;
	}

	@SerializedName("age")
	@Expose
	private int age;

	protected Registered(Parcel in) {
		date = in.readString();
		age = in.readInt();
	}

	public static final Creator<Registered> CREATOR = new Creator<Registered>() {
		@Override
		public Registered createFromParcel(Parcel in) {
			return new Registered(in);
		}

		@Override
		public Registered[] newArray(int size) {
			return new Registered[size];
		}
	};

	public String getDate(){
		return date;
	}

	public int getAge(){
		return age;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(date);
		parcel.writeInt(age);
	}
}
