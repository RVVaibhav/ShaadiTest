package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location extends BaseObservable implements Parcelable {

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void setState(String state) {
		this.state = state;
	}

	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("city")
	@Expose
	private String city;
	@SerializedName("street")
	@Expose
	private Street street;
	@SerializedName("timezone")
	@Expose
	private Timezone timezone;

	@SerializedName("postcode")
	@Expose
	private String postcode;
	@SerializedName("coordinates")
	@Expose
	private Coordinates coordinates;

	@SerializedName("state")
	@Expose
	private String state;

	protected Location(Parcel in) {
		country = in.readString();
		city = in.readString();
		street = in.readParcelable(Street.class.getClassLoader());
		timezone = in.readParcelable(Timezone.class.getClassLoader());
		postcode = in.readString();
		state = in.readString();
	}

	public static final Creator<Location> CREATOR = new Creator<Location>() {
		@Override
		public Location createFromParcel(Parcel in) {
			return new Location(in);
		}

		@Override
		public Location[] newArray(int size) {
			return new Location[size];
		}
	};

	public String getCountry(){
		return country;
	}

	public String getCity(){
		return city;
	}

	public Street getStreet(){
		return street;
	}

	public Timezone getTimezone(){
		return timezone;
	}

	public String getPostcode(){
		return postcode;
	}

	public Coordinates getCoordinates(){
		return coordinates;
	}

	public String getState(){
		return state;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(country);
		parcel.writeString(city);
		parcel.writeParcelable(street, i);
		parcel.writeParcelable(timezone, i);
		parcel.writeString(postcode);
		parcel.writeString(state);
	}
}
