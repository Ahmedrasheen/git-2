package com.omrbranch.stepdefnition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.login.Login_Output_POJO;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class LoginstepDefenition extends  BaseClass{
	


	@Given("User add header")
	public void user_add_header() {
		addHeader("accept", "application/json");
	}
	
	@When("User add basic authentication for login")
	public void user_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		addBasicAuthentication(getPropertiesValue("userName"),getPropertiesValue("password"));
	}
	
	@When("User send {string} request for login endpoint")
	public void user_send_request_for_login_endpoint(String type) {
		response = addReqType(type,Endpoints.LOGIN);
	}

	
	@Then("User should verify the login responsebody firstname present as {string} and get logToken saved")
	public void user_should_verify_the_login_responsebody_firstname_present_as_and_get_log_token_saved(String string) {
		
		Login_Output_POJO login_output_POJO = response.as(Login_Output_POJO.class);
			String first_name = login_output_POJO.getData().getFirst_name();
			 Assert.assertEquals("verify firstName",string,first_name);	
			 System.out.println(first_name);
			 data.setLogtoken(login_output_POJO.getData().getLogtoken());
	}



}
