package com.omrbranch.stepdefnition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.product.SearchProduct_Output_Root_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import omr.payload.product.ProductPayload;

public class ProductStepDefeniton extends BaseClass {

	static ProductPayload productpayload=new ProductPayload();
@Given("User add header for search product")
public void user_add_header_for_search_product() {
	List<Header>header=new ArrayList<>();
	Header h1=new Header("accept","application/json");
	Header h2=new Header("Content-Type","application/json");
	header.add(h1);
	header.add(h2);

	Headers headers=new Headers(header);
	addHeaders(headers);
}

@When("User add request body for search product {string}")
public void user_add_request_body_for_search_product(String string) {
	 addBody(productpayload.searchproduct(string));
}

@When("User send {string} request for productSearch endpoint")
public void user_send_request_for_product_search_endpoint(String string) {
	response = addReqType(string,Endpoints.SEARCHPRODUCT);
}

@Then("User should verify productSearch message matches {string}")
public void user_should_verify_product_search_message_matches(String string) {
	 SearchProduct_Output_Root_Pojo output_Root_Pojo=response.as(SearchProduct_Output_Root_Pojo.class);
	    String message = output_Root_Pojo.getMessage();
	    
	    System.out.println("searchProduuct success message==>>>>"+message);	    
		Assert.assertEquals("verify search Product",message,string);
}



}
