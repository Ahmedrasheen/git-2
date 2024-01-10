package com.omrbranch.stepdefnition;
import java.util.ArrayList;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.State_output_Pojo;
import com.omrbranch.pojo.address.State_output_data_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class StateListStepDefenition extends BaseClass {

	
	
	
	@Given("user add header for StateList")
	public void user_add_header_for_state_list() {
		addHeader("accept", "application/json");
	}
	@When("user send {string} request for StateList endpoint")
	public void user_send_request_for_state_list_endpoint(String string) {
		 response = addReqType(string,Endpoints.STATEID);
	}
	
	@Then("User should verify the StateList response message matches {string} and saved StateId")
	public void user_should_verify_the_state_list_response_message_matches_and_saved_state_id(String string) {
		State_output_Pojo as = response.as(State_output_Pojo.class);
		 
		ArrayList<State_output_data_Pojo> value = as.getData();
	
		String ExpString=string;
		
	 for (State_output_data_Pojo datas : value) {
		
		 String name = datas.getName();
		
		if(name.equals(ExpString)) {
			
		     data.setStateid( datas.getId());
			
			System.out.println("State ID:"+datas.getId());
			
			data.setStId(String.valueOf(datas.getId()));
			
			Assert.assertEquals("Verify  State Id","35",data.getStId());
	}



	 }}}
