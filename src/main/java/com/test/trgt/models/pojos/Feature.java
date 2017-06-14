package com.test.trgt.models.pojos;

import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "feature" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Feature {

	@JsonProperty("feature")
	private String feature;

	@JsonProperty("feature")
	public String getFeature() {
		return feature;
	}

	@JsonProperty("feature")
	public void setFeature(String feature) {
		this.feature = feature;
	}

}