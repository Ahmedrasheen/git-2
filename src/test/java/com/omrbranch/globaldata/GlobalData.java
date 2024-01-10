package com.omrbranch.globaldata;

import io.restassured.response.Response;

public class GlobalData {

	private Response response;
	private String Logtoken;
	private int Stateid;
	private String StId;
	private int  Cityid;
	private String addressID;
	

	public String getAddressID() {
		return addressID;
	}
	public void setAddressID(String addressID) {
		this.addressID = addressID;
	}
	public int getCityid() {
		return Cityid;
	}
	public void setCityid(int cityid) {
		Cityid = cityid;
	}
	public int getStateid() {
		return Stateid;
	}
	public void setStateid(int stateid) {
		Stateid = stateid;
	}
	public String getStId() {
		return StId;
	}
	public void setStId(String stId) {
		StId = stId;
	}
	 public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public String getLogtoken() {
		return Logtoken;
	}
	public void setLogtoken(String logtoken) {
		Logtoken = logtoken;
	}
	
}
