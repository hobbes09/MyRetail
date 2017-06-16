package com.test.trgt.data;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;
import com.test.trgt.models.Price;
import com.test.trgt.models.Product;
import com.mongodb.util.JSON;

public class PricesRepository {
	
	DBCollection collection = DbManager.dbManager.getPricesCollection();
	
	// TODO : To be injected
	ObjectMapper mapper = new ObjectMapper();
	
	public Price getPriceByProductId(int productId){
		
		DBObject query = BasicDBObjectBuilder.start().add("product_id", productId).get();
		DBCursor cursor = collection.find(query);
		if (cursor.hasNext()){
			return getPriceFromDbObject(cursor.next());
		}
		
		return null;
	}
	
	public boolean addPriceByProductId(Price price){
		
		try {
			String jsonInString = mapper.writeValueAsString(price);
			
			if (jsonInString != null){
				DBObject dbObject = (DBObject) JSON.parse(jsonInString);
				WriteResult result = collection.insert(dbObject);
				if (result.getUpsertedId() != null)
					return true;
				else
					return false;
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private Price getPriceFromDbObject(DBObject priceDbObject){
		
		if (priceDbObject == null)
			return null;
		else {
			Price price = new Price(((Number) priceDbObject.get("product_id")).intValue(), 
					((Number) priceDbObject.get("value")).intValue(), 
					priceDbObject.get("current_code").toString());
			return price;
		}
	}

}
