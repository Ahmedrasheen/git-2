package com.omrbranch.stepdefnition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.AddAddress_Output_pojo;
import com.omrbranch.pojo.address.Delete_Ouput_Pojo;
import com.omrbranch.pojo.address.GetAddress_output_Root_Pojo;
import com.omrbranch.pojo.address.UpdateAddress_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import omr.payload.address.Address_PayLoad;

public class AddressStepDefenition extends BaseClass {

	static Address_PayLoad addressPayload = new Address_PayLoad();

	@Given("User add header and bearer authorization for accessing address endpoints")
	public void user_add_header_and_bearer_authorization_for_accessing_address_endpoints() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + data.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);
	}

	@When("User add requestbody for add new address {string},{string},{string},{string},{int} and {int} and {int},{string},{string} and {string}")
	public void user_add_requestbody_for_add_new_address_and_and_and(String string, String string2, String string3,
			String string4, Integer int1, Integer int2, Integer int3, String string5, String string6, String string7) {
		addBody(addressPayload.addAddressPayLoad(string, string2, string3, string4, int1, int2, int3, string5, string6,
				string7));

	}

	@When("User sent {string} request for addUserAddress endpoint")
	public void user_sent_request_for_add_user_address_endpoint(String string) {
		response = addReqType(string, Endpoints.ADDADDRESS);
	}

	@Then("User should verify the addUserAddress response message matches {string} and get userId saved")
	public void user_should_verify_the_add_user_address_response_message_matches_and_get_user_id_saved(String string) {
		AddAddress_Output_pojo addAddress_Output_pojo = response.as(AddAddress_Output_pojo.class);

		String message = addAddress_Output_pojo.getMessage();

		int address_id = addAddress_Output_pojo.getAddress_id();
		data.setAddressID(String.valueOf(address_id));
		System.out.println("Address Id==>>>>" + data.getAddressID());

		System.out.println("AddAddress success message==>>>>" + message);
		Assert.assertEquals("verify Address Added", message, string);

	}

	@When("User send {string} request for getUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String string) {

		response = addReqType("GET", Endpoints.GETADDRESS);
	}

	@Then("User shoud verify getUserAddress respond message matches {string}")
	public void user_shoud_verify_get_user_address_respond_message_matches(String string) {
		GetAddress_output_Root_Pojo as = response.as(GetAddress_output_Root_Pojo.class);
		String message = as.getMessage();
		System.out.println("getAddress success message==>>>>" + message);
		Assert.assertEquals("verify get User Address", message, string);
	}

	@When("User add request body userId for  update address {string},{string},{string},{string},{string},{int} and {int} and {int},{string},{string} and {string}")
	public void user_add_request_body_user_id_for_update_address_and_and_and(String string, String string2, String string3, String string4, String string5, Integer int1, Integer int2, Integer int3, String string6, String string7, String string8) {
		addBody(addressPayload.updateAddressPayload(data.getAddressID(), string2, string3, string4, string5, int1, int2,
				int3, string6, string7, string8));
	}

	@When("User send {string} request for updateAddress endpoint")
	public void user_send_request_for_update_address_endpoint(String string) {
		response = addReqType(string,Endpoints.UPDATEADDRESS);
	}

	@Then("User should verify updateAddress respond message {string}")
	public void user_should_verify_update_address_respond_message(String string) {
		
		UpdateAddress_Output_pojo address_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		String message = address_Output_pojo.getMessage();
		System.out.println("Update address success messsage==>>>>" + message);
		Assert.assertEquals("verify updated Address", message, string);
	}

	@When("User add requestbody for delete address {string}")
	public void user_add_requestbody_for_delete_address(String string) {
		addBody(addressPayload.deleteAddressPayload(data.getAddressID()));
	}

	@When("User sent {string} request for deleteUserAddress endpoint")
	public void user_sent_request_for_delete_user_address_endpoint(String string) {
		response = addReqType("DELETE", Endpoints.DELETE);
	}

	@Then("User should verify the DeleteAddress response message matches {string}")
	public void user_should_verify_the_delete_address_response_message_matches(String string) {
		Delete_Ouput_Pojo as = response.as(Delete_Ouput_Pojo.class);
		String message = as.getMessage();
		System.out.println("Delete address successfully==>>>>" + message);
		Assert.assertEquals("verify Deleted sucessfully", message, string);
	}

}
