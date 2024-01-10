package omr.payload.product;

import com.omrbranch.pojo.product.SearchProduct_Input_Pojo;

public class ProductPayload {
	public SearchProduct_Input_Pojo searchproduct(String product) {
		SearchProduct_Input_Pojo input_Pojo=new SearchProduct_Input_Pojo(product);
		return input_Pojo;
}
}
