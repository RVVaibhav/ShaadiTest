package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsItem extends BaseObservable implements Parcelable {

	@SerializedName("nat")
	@Expose
	private String nat;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("phone")
	@Expose
	private String phone;
	@SerializedName("dob")
	@Expose
	private Dob dob;

	@SerializedName("name")
	@Expose
	private Name name;
	@SerializedName("registered")
	@Expose
	private Registered registered;
	@SerializedName("location")
	@Expose
	private Location location;
	@SerializedName("id")
	@Expose
	private Id id;
	@SerializedName("login")
	@Expose
	private Login login;
	@SerializedName("cell")
	@Expose
	private String cell;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("picture")
	@Expose
	private Picture picture;

	protected ResultsItem(Parcel in) {
		nat = in.readString();
		gender = in.readString();
		phone = in.readString();
		cell = in.readString();
		email = in.readString();
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

    public ResultsItem() {

    }

    public String getNat(){
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setDob(Dob dob) {
		this.dob = dob;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setRegistered(Registered registered) {
		this.registered = registered;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	public String getGender(){
		return gender;
	}

	public String getPhone(){
		return phone;
	}

	public Dob getDob(){
		return dob;
	}

	public Name getName(){
		return name;
	}

	public Registered getRegistered(){
		return registered;
	}

	public Location getLocation(){
		return location;
	}

	public Id getId(){
		return id;
	}

	public Login getLogin(){
		return login;
	}

	public String getCell(){
		return cell;
	}

	public String getEmail(){
		return email;
	}

	public Picture getPicture(){
		return picture;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(nat);
		parcel.writeString(gender);
		parcel.writeString(phone);
		parcel.writeString(cell);
		parcel.writeString(email);
	}
}
