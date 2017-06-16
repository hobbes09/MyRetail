package com.test.trgt.data;

import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.test.trgt.config.ApplicationConfig;

public class DbManager {
	
	public static final String COLLECTION_PRICES = "prices";
	
	private MongoClient mongo;
	private DB db;
	private DBCollection pricesCollection;
	private MongoDbFactory mongoDbFactory;
	private MongoTemplate mongoTemplate;
	
	public static DbManager dbManager = new DbManager();
	
	private DbManager(){
		try {
			mongo = new MongoClient(ApplicationConfig.MONGO_HOST, ApplicationConfig.MONGO_PORT);
			db = mongo.getDB(ApplicationConfig.MONGO_DB_NAME);
			pricesCollection = db.getCollection(COLLECTION_PRICES);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Collection to Mongo Database failed !");
		}
		
		if (mongo != null){
			mongoDbFactory = new SimpleMongoDbFactory(mongo, ApplicationConfig.MONGO_DB_NAME);
			mongoTemplate = new MongoTemplate(mongoDbFactory);
		}
		
	}

	public MongoClient getMongo() {
		return mongo;
	}

	public void setMongo(MongoClient mongo) {
		this.mongo = mongo;
	}

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}

	public DBCollection getPricesCollection() {
		return pricesCollection;
	}

	public void setPricesCollection(DBCollection pricesCollection) {
		this.pricesCollection = pricesCollection;
	}

	public MongoDbFactory getMongoDbFactory() {
		return mongoDbFactory;
	}

	public void setMongoDbFactory(MongoDbFactory mongoDbFactory) {
		this.mongoDbFactory = mongoDbFactory;
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
