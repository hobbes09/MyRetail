package com.test.trgt.models.pojos;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "product_composite_response" })
@XmlRootElement(name = "product_composite_response")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtProductResponse {

	@JsonProperty("product_composite_response")
	private ProductCompositeResponse productCompositeResponse;

	@JsonProperty("product_composite_response")
	public ProductCompositeResponse getProductCompositeResponse() {
		return productCompositeResponse;
	}

	@JsonProperty("product_composite_response")
	public void setProductCompositeResponse(ProductCompositeResponse productCompositeResponse) {
		this.productCompositeResponse = productCompositeResponse;
	}
}