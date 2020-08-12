package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dob extends BaseObservable implements Parcelable {
	@SerializedName("date")
	@Expose
	private String date;

	public void setDate(String date) {
		this.date = date;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@SerializedName("age")
	@Expose
	private int age;

	protected Dob(Parcel in) {
		date = in.readString();
		age = in.readInt();
	}

	public static final Creator<Dob> CREATOR = new Creator<Dob>() {
		@Override
		public Dob createFromParcel(Parcel in) {
			return new Dob(in);
		}

		@Override
		public Dob[] newArray(int size) {
			return new Dob[size];
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
