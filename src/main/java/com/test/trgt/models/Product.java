package com.test.trgt.models;

import com.test.trgt.utils.BuildString;

public class Product {
	
	private int id;
	private String name;
	private String url;
	private Price price;
	private Error error;
	
	public Product(){
		this.id = 0;
		this.name = "";
		this.url = "";
	}
	
	public Product(int id, String name, String url, Price price, Error error) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.price = price;
		this.error = error;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return BuildString.init("Product{")
                .append("id=").append(id)
                .append(", name='").append(name)
                .append(", url=").append(url)
                .append(", price=").append(price)
                .append(", error=").append(error)
                .append('}').get();
	}
	
}
