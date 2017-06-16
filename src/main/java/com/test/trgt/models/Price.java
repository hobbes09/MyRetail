package com.test.trgt.models;

import com.test.trgt.utils.BuildString;

public class Price {
	
	int product_id;
	int value;
	String current_code;
	
	public Price(int product_id, int value, String current_code) {
		super();
		this.product_id = product_id;
		this.value = value;
		this.current_code = current_code;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCurrent_code() {
		return current_code;
	}

	public void setCurrent_code(String current_code) {
		this.current_code = current_code;
	}

	@Override
	public String toString() {
		return BuildString.init("Price{")
                .append("product_id=").append(product_id)
                .append(", value='").append(value)
                .append(", current_code=").append(current_code)
                .append('}').get();
	}
}
