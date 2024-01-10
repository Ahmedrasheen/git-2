package com.omrbranch.stepdefnition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.State_output_Pojo;
import com.omrbranch.pojo.address.State_output_data_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import omr.payload.address.Address_PayLoad;

public class CityListStepDefenition extends BaseClass{
	
	static Address_PayLoad addressPayload=new Address_PayLoad();
	
	
	@Given("User add header for to get CityList")
	public void user_add_header_for_to_get_city_list() {
		List<Header> headername=new ArrayList<>();
		Header h1=new Header("accept","application/json");
		Header h2=new Header("Content-Type","application/json");
		headername.add(h1);
		headername.add(h2);
        
		Headers headers=new Headers(headername);
         addHeaders(headers);
	}
	
	@When("User add requestbody StateId for get CityList")
	public void user_add_requestbody_state_id_for_get_city_list() {
		 
		 addBody(addressPayload.addCityPAyLoad(data.getStId()));
	}
	
	@When("User send {string} request for CityList endpoint")
	public void user_send_request_for_city_list_endpoint(String string) {
		
		  response = addReqType(string,Endpoints.CITYID);
	}
	
	@Then("User verify the CityList response message matches {string} and saved CityId")
	public void user_verify_the_city_list_response_message_matches_and_saved_city_id(String string) {
		
		State_output_Pojo city_Output_Root_Pojo = response.as(State_output_Pojo.class);
		    
         ArrayList<State_output_data_Pojo> value = city_Output_Root_Pojo.getData();
       
        String expCity=string;
        
        for (State_output_data_Pojo datas : value) {
			
       	 String name = datas.getName();
			
       	 if(name.equals(expCity)) {
			
       		data.setCityid(datas.getId());	 
       		 System.out.println("City Name  "+name+" City ID  "+datas.getId());
				Assert.assertEquals("Verify City ID",4440,datas.getId());
				break;
			}
		}
	}
}
