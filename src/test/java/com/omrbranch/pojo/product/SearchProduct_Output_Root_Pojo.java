package com.omrbranch.pojo.product;

import java.util.ArrayList;

public class SearchProduct_Output_Root_Pojo {
	public int status;
	public String message;
    public ArrayList<SearchProduct_Output_Data_Pojo> data;
    public String currency;
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public ArrayList<SearchProduct_Output_Data_Pojo> getData() {
		return data;
	}
	public String getCurrency() {
		return currency;
	}
    
}
