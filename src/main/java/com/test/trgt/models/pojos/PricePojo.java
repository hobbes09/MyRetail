package com.test.trgt.models.pojos;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import com.test.trgt.utils.BuildString;

public class PricePojo {
	
	int value;
	String current_code;
	
	@JsonCreator
	public PricePojo(@JsonProperty("value") int value, @JsonProperty("current_code") String current_code) {
		super();
		this.value = value;
		this.current_code = current_code;
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
		return BuildString.init("PricePojo{")
                .append("value='").append(value)
                .append(", current_code=").append(current_code)
                .append('}').get();
	}
}
