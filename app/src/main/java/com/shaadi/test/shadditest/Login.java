package com.shaadi.test.shadditest;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login extends BaseObservable implements Parcelable {
	@SerializedName("sha1")
	@Expose
	private String sha1;

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	@SerializedName("password")
	@Expose
	private String password;
	@SerializedName("salt")
	@Expose
	private String salt;
	@SerializedName("sha256")
	@Expose
	private String sha256;
	@SerializedName("uuid")
	@Expose
	private String uuid;
	@SerializedName("username")
	@Expose
	private String username;
	@SerializedName("md5")
	@Expose
	private String md5;

	protected Login(Parcel in) {
		sha1 = in.readString();
		password = in.readString();
		salt = in.readString();
		sha256 = in.readString();
		uuid = in.readString();
		username = in.readString();
		md5 = in.readString();
	}

	public static final Creator<Login> CREATOR = new Creator<Login>() {
		@Override
		public Login createFromParcel(Parcel in) {
			return new Login(in);
		}

		@Override
		public Login[] newArray(int size) {
			return new Login[size];
		}
	};

	public String getSha1(){
		return sha1;
	}

	public String getPassword(){
		return password;
	}

	public String getSalt(){
		return salt;
	}

	public String getSha256(){
		return sha256;
	}

	public String getUuid(){
		return uuid;
	}

	public String getUsername(){
		return username;
	}

	public String getMd5(){
		return md5;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(sha1);
		parcel.writeString(password);
		parcel.writeString(salt);
		parcel.writeString(sha256);
		parcel.writeString(uuid);
		parcel.writeString(username);
		parcel.writeString(md5);
	}
}
