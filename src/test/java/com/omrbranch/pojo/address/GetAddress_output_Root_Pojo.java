package com.omrbranch.pojo.address;

import java.util.ArrayList;

public class GetAddress_output_Root_Pojo {
	 public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<GetAdress_Output_Data_POJO> getData() {
		return data;
	}
	public void setData(ArrayList<GetAdress_Output_Data_POJO> data) {
		this.data = data;
	}
	public int status;
	    public String message;
	    public ArrayList<GetAdress_Output_Data_POJO> data;
}
