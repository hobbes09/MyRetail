package com.test.trgt.service;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.test.trgt.models.Product;
import com.test.trgt.models.pojos.ExtProductResponse;

public class ProductService {
	
	Client client = Client.create();
		
	ObjectMapper mapper = new ObjectMapper();
	
	public Product getProductDetailsById(long id){
		
		try {
			WebResource webResource = client
				   .resource("https://api.target.com/products/v3/52379290?fields=descriptions&id_type=TCIN&key=43cJWpLjH8Z8oR18KdrZDBKAgLLQKJjz");
			
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
						
			ExtProductResponse extProductResponse = mapper.readValue(response.getEntity(String.class), ExtProductResponse.class);
			
			return new Product(99999, extProductResponse.getProductCompositeResponse()
					.getItems().get(0).getDataPageLink());
			
		} catch (Exception e){}
		
		return new Product(id, "Batman Costume");
	}

}
