package com.jhamobi.trackiya.client.model;

import java.io.Serializable;

public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String type;
	private String number;
	private String driverName;
	private String ownerName;
	private String driverPhNumber;
	private String ownerPhoneNumber;
	private String rateAbove1500Km;
	private String rateWithin1500Km;
	private String rateAbove12Hrs;
	private String rateWithin12Hrs;
	private Hub hub;
	private TrackingData trackingData; 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getDriverPhNumber() {
		return driverPhNumber;
	}

	public void setDriverPhNumber(String driverPhNumber) {
		this.driverPhNumber = driverPhNumber;
	}

	public String getOwnerPhoneNumber() {
		return ownerPhoneNumber;
	}

	public void setOwnerPhoneNumber(String ownerPhoneNumber) {
		this.ownerPhoneNumber = ownerPhoneNumber;
	}

	public Hub getHub() {
		return hub;
	}

	public void setHub(Hub hub) {
		this.hub = hub;
	}

	public TrackingData getTrackingData() {
		return trackingData;
	}

	public void setTrackingData(TrackingData trackingData) {
		this.trackingData = trackingData;
	}

	public String getRateAbove1500Km() {
		return rateAbove1500Km;
	}

	public void setRateAbove1500Km(String rateAbove1500Km) {
		this.rateAbove1500Km = rateAbove1500Km;
	}

	public String getRateWithin1500Km() {
		return rateWithin1500Km;
	}

	public void setRateWithin1500Km(String rateWithin1500Km) {
		this.rateWithin1500Km = rateWithin1500Km;
	}

	public String getRateAbove12Hrs() {
		return rateAbove12Hrs;
	}

	public void setRateAbove12Hrs(String rateAbove12Hrs) {
		this.rateAbove12Hrs = rateAbove12Hrs;
	}

	public String getRateWithin12Hrs() {
		return rateWithin12Hrs;
	}

	public void setRateWithin12Hrs(String rateWithin12Hrs) {
		this.rateWithin12Hrs = rateWithin12Hrs;
	}
	
	
	
}
