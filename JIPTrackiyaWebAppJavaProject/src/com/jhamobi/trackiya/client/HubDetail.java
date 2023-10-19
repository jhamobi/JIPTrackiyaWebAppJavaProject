package com.jhamobi.trackiya.client;

public class HubDetail {
	private String mHubId;
	private String mHubName;
	private String mHubCity;
	private String mHubZone;
	private String mHubAddress;

	public HubDetail(String hubId, String hubName, String hubCity, String hubZone, String hubAddress) {
		this.mHubId = hubId;
		this.mHubName = hubName;
		this.mHubCity = hubCity;
		this.mHubZone = hubZone;
		this.mHubAddress = hubAddress;
	}

	public String getHubId() {
		return mHubId;
	}

	public void setHubId(String hubId) {
		mHubId = hubId;
	}
	
	public String getHubName() {
		return mHubName;
	}

	public void setHubName(String hubName) {
		mHubName = hubName;
	}
	
	public String getHubCity() {
		return mHubCity;
	}

	public void setHubCity(String hubCity) {
		mHubCity = hubCity;
	}
	
	public String getHubZone() {
		return mHubZone;
	}

	public void setHubZone(String hubZone) {
		mHubZone = hubZone;
	}

	public String getHubAddress() {
		return mHubAddress;
	}

	public void setHubAddress(String hubAddress) {
		mHubAddress = hubAddress;
	}
}
