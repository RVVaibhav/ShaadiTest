package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coordinates extends BaseObservable implements Parcelable {
	@SerializedName("latitude")
	@Expose
	private String latitude;
	@SerializedName("longitude")
	@Expose
	private String longitude;

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	protected Coordinates(Parcel in) {
		latitude = in.readString();
		longitude = in.readString();
	}

	public static final Creator<Coordinates> CREATOR = new Creator<Coordinates>() {
		@Override
		public Coordinates createFromParcel(Parcel in) {
			return new Coordinates(in);
		}

		@Override
		public Coordinates[] newArray(int size) {
			return new Coordinates[size];
		}
	};

	public String getLatitude(){
		return latitude;
	}

	public String getLongitude(){
		return longitude;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(latitude);
		parcel.writeString(longitude);
	}
}
