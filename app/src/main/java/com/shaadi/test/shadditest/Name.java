package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name extends BaseObservable implements Parcelable {
	@SerializedName("last")
	@Expose
	private String last;
	@SerializedName("title")
	@Expose
	private String title;
	@SerializedName("first")
	@Expose
	private String first;

	public void setLast(String last) {
		this.last = last;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	protected Name(Parcel in) {
		last = in.readString();
		title = in.readString();
		first = in.readString();
	}

	public static final Creator<Name> CREATOR = new Creator<Name>() {
		@Override
		public Name createFromParcel(Parcel in) {
			return new Name(in);
		}

		@Override
		public Name[] newArray(int size) {
			return new Name[size];
		}
	};

	public String getLast(){
		return last;
	}

	public String getTitle(){
		return title;
	}

	public String getFirst(){
		return first;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(last);
		parcel.writeString(title);
		parcel.writeString(first);
	}
}
