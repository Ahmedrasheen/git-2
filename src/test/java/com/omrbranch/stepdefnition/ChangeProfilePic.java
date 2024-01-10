package com.omrbranch.stepdefnition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.changeprofilepic.ProfilePic_Output_Pojo;
import com.omrbranch.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class ChangeProfilePic extends BaseClass{

	
	@Given("User add header,bearer authorization and multipart for accessing changeProfilePic endpoint")
	public void user_add_header_bearer_authorization_and_multipart_for_accessing_change_profile_pic_endpoint() {
		List<Header>header=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Authorization","Bearer "+data.getLogtoken());
		Header h3=new Header("Content-Type","multipart/form-data");
		header.add(h1);
		header.add(h2);
		header.add(h3);
	
		Headers headers=new Headers(header);
		addHeaders(headers);}
	
	@When("User add  the file to change profile picture")
	public void user_add_the_file_to_change_profile_picture() {
		addFormData("profile_picture", new File("C:\\Users\\shari\\eclipse-TestNG\\ApiTestingTasks\\Image\\Ronaldo.jpeg")); 
	}
    @When("User sent {string} request for changeProfilePic endpoint")
	public void user_sent_request_for_change_profile_pic_endpoint(String string) {
		response=addReqType(string,Endpoints.ADDPROFILE);
	}

	@Then("User Should verify changeProfilePic respond message matches {string}")
	public void user_should_verify_change_profile_pic_respond_message_matches(String string) {
		ProfilePic_Output_Pojo output_Pojo=response.as(ProfilePic_Output_Pojo.class);
		
		String message = output_Pojo.getMessage();
		System.out.println("chamge profile success message==>>>>"+message);
		Assert.assertEquals("verify profile pic successful added",message,string);	
		
	}
	
	

	}







