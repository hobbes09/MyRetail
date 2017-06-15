package com.test.trgt.service;

import com.test.trgt.models.Error;
import org.codehaus.jackson.map.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.test.trgt.config.ApplicationConfig;
import com.test.trgt.exceptions.BaseException;
import com.test.trgt.exceptions.HttpException;
import com.test.trgt.exceptions.RequestException;
import com.test.trgt.exceptions.ServerException;
import com.test.trgt.models.Product;
import com.test.trgt.models.pojos.ExtProductResponse;

import okhttp3.HttpUrl;

public class ProductService {
	
	// TODO : To be injected
	Client client = Client.create();
		
	// TODO : To be injected
	ObjectMapper mapper = new ObjectMapper();
	
	public Product getProductDetailsById(long id) throws BaseException{
		
		if (id <= 0)
			throw new RequestException().setResponseCode(404);
		
		try {
			WebResource webResource = client
				   .resource(getProductRequestByIdUrl(id));
			
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			
			if (response.getStatus() != 200) {
				throw new HttpException().setResponseCode(response.getStatus());
			}
						
			ExtProductResponse extProductResponse = mapper.readValue(response.getEntity(String.class), ExtProductResponse.class);
						
			if (extProductResponse.getProductCompositeResponse().getItems().isEmpty() || 
					extProductResponse.getProductCompositeResponse().getItems().get(0).getDataPageLink() == null){
				return new Product(id, null, null, new Error("Product with this ID is not available", 404));
			}
			
			return new Product(id, extProductResponse.getProductCompositeResponse().getItems().get(0).getOnlineDescription().getValue(), 
					extProductResponse.getProductCompositeResponse().getItems().get(0).getDataPageLink(), null);
			
		} catch (Exception e){
			throw new ServerException().setResponseCode(500);
		}
	}
	
	public String getProductRequestByIdUrl(long id){
		
		return new HttpUrl.Builder()
			    .scheme(ApplicationConfig.SCHEME)
			    .host(ApplicationConfig.EXT_BASE_URL)
			    .addPathSegments("products/v3/" + id)
			    .addQueryParameter("fields", ApplicationConfig.EXT_FIELDS)
			    .addQueryParameter("id_type", ApplicationConfig.EXT_ID_TYPE)
			    .addQueryParameter("key", ApplicationConfig.EXT_KEY)
			    .build().url().toString();
	}

}
