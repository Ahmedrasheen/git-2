package omr.payload.address;

import com.omrbranch.pojo.address.AddAddress_Input_pojo;
import com.omrbranch.pojo.address.City_Input_Root_Pojo;
import com.omrbranch.pojo.address.Delete_input_pojo;
import com.omrbranch.pojo.address.UpdateAddress_Input_pojo;

public class Address_PayLoad {
 
	
public City_Input_Root_Pojo addCityPAyLoad(String StateId) {
	
	City_Input_Root_Pojo city_Input_Root_Pojo=new City_Input_Root_Pojo(StateId);
	
	return city_Input_Root_Pojo;
}
public AddAddress_Input_pojo addAddressPayLoad(String first_name, String last_name, String mobile, String apartment, int state,
		int city, int country, String zipcode, String address, String address_type) {
	
	AddAddress_Input_pojo addAddress_Input_pojo=new AddAddress_Input_pojo( first_name,  last_name,  mobile,  apartment,  state,
	 city,  country,  zipcode,  address,  address_type);
	
	return addAddress_Input_pojo;
}
public UpdateAddress_Input_pojo updateAddressPayload(String address_id, String first_name, String last_name, String mobile,
		String apartment, int state, int city, int country, String zipcode, String address,
		String address_type) {
	
	UpdateAddress_Input_pojo address_Input_pojo=new UpdateAddress_Input_pojo( address_id,  first_name,  last_name,  mobile,
		 apartment,  state,  city,  country,  zipcode,  address,
		 address_type);
	
	return  address_Input_pojo;
	
}
public Delete_input_pojo deleteAddressPayload(String addressID) {
	
	Delete_input_pojo delete_input_pojo=new Delete_input_pojo(addressID);
	
	return delete_input_pojo;	

}
}
