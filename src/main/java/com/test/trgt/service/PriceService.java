package com.test.trgt.service;

import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.sun.jersey.api.client.Client;
import com.test.trgt.data.PricesRepository;
import com.test.trgt.models.Price;
import com.test.trgt.models.pojos.PricePojo;

public class PriceService {
	
	Client client;
	ObjectMapper mapper;
	PricesRepository pricesRepository;
	
	static PriceService priceService = new PriceService();
	
	public static PriceService getInstance(){
		if (priceService == null)
			priceService = new PriceService();
		return priceService;
	}
	
	public PriceService() {
		super();
		this.client = Client.create();
		this.mapper = new ObjectMapper();
		this.pricesRepository = PricesRepository.getInstance();
	}
	
	public boolean updatePriceForProductId(int productId, PricePojo pricePojo){
		
		if (productId <= 0)
			return false;
		
		if (pricesRepository.getPriceByProductId(productId) == null)
			return false;
		
		Price price = new Price(productId, pricePojo.getValue(), pricePojo.getCurrent_code());
		return pricesRepository.updatePriceByProductId(productId, price);
	}

}
