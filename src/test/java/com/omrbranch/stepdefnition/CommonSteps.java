package com.omrbranch.stepdefnition;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;

import io.cucumber.java.en.Then;

public class CommonSteps extends BaseClass{
     
	@Then("User should verify statuscode is {int}")
	public void user_should_verify_statuscode_is(int  statusCode) {
		int resStatusCode = getResStatusCode();
		System.out.println("login status code:"+resStatusCode);		
	   Assert.assertEquals("verify",statusCode, resStatusCode);
	}
}
