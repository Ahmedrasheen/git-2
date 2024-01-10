package com.omrbranch.pojo.address;

import java.util.ArrayList;

public class State_output_Pojo {
	 private int status;
	    private String message;
	   
		private ArrayList<State_output_data_Pojo> data;
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
		public ArrayList<State_output_data_Pojo> getData() {
			return data;
		}
		public void setData(ArrayList<State_output_data_Pojo> data) {
			this.data = data;
		}
}
