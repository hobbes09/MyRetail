package com.test.trgt.models;

public class Product {
	
	private long id;
	private String name;
	private String url;
	private Error error;
	
	public Product(){
		this.id = 0;
		this.name = "";
		this.url = "";
	}
	
	public Product(long id, String name, String url, Error error) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.error = error;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	
}
