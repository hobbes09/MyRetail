package com.test.trgt.models.pojos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({ "relation_description", "data_page_link", "imn_identifier", "general_description",
		"online_description", "store_description", "features" })
public class Item {

	@JsonProperty("relation_description")
	private String relationDescription;
	@JsonProperty("data_page_link")
	private String dataPageLink;
	@JsonProperty("imn_identifier")
	private Integer imnIdentifier;
	@JsonProperty("general_description")
	private String generalDescription;
	@JsonProperty("online_description")
	private OnlineDescription onlineDescription;
	@JsonProperty("store_description")
	private StoreDescription storeDescription;
	@JsonProperty("features")
	private List<Feature> features = null;

	@JsonProperty("relation_description")
	public String getRelationDescription() {
		return relationDescription;
	}

	@JsonProperty("relation_description")
	public void setRelationDescription(String relationDescription) {
		this.relationDescription = relationDescription;
	}

	@JsonProperty("data_page_link")
	public String getDataPageLink() {
		return dataPageLink;
	}

	@JsonProperty("data_page_link")
	public void setDataPageLink(String dataPageLink) {
		this.dataPageLink = dataPageLink;
	}

	@JsonProperty("imn_identifier")
	public Integer getImnIdentifier() {
		return imnIdentifier;
	}

	@JsonProperty("imn_identifier")
	public void setImnIdentifier(Integer imnIdentifier) {
		this.imnIdentifier = imnIdentifier;
	}

	@JsonProperty("general_description")
	public String getGeneralDescription() {
		return generalDescription;
	}

	@JsonProperty("general_description")
	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	@JsonProperty("online_description")
	public OnlineDescription getOnlineDescription() {
		return onlineDescription;
	}

	@JsonProperty("online_description")
	public void setOnlineDescription(OnlineDescription onlineDescription) {
		this.onlineDescription = onlineDescription;
	}

	@JsonProperty("store_description")
	public StoreDescription getStoreDescription() {
		return storeDescription;
	}

	@JsonProperty("store_description")
	public void setStoreDescription(StoreDescription storeDescription) {
		this.storeDescription = storeDescription;
	}

	@JsonProperty("features")
	public List<Feature> getFeatures() {
		return features;
	}

	@JsonProperty("features")
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

}