package com.jhamobi.trackiya.client.model;

import java.io.Serializable;

public class RunningData implements Serializable {

	private static final long serialVersionUID = 1L;

	private double latitute;

	private double longitude;

	private String distanceTravelled;

	private String timeTravelled;
	
	private String currentAddress;
	
	private String time;
	
	private boolean isBreakDown;
	
	private boolean isRunning;

	public double getLatitute() {
		return latitute;
	}

	public void setLatitute(double latitute) {
		this.latitute = latitute;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getDistanceTravelled() {
		return distanceTravelled;
	}

	public void setDistanceTravelled(String distanceTravelled) {
		this.distanceTravelled = distanceTravelled;
	}

	public String getTimeTravelled() {
		return timeTravelled;
	}

	public void setTimeTravelled(String timeTravelled) {
		this.timeTravelled = timeTravelled;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public boolean isBreakDown() {
		return isBreakDown;
	}

	public void setBreakDown(boolean isBreakDown) {
		this.isBreakDown = isBreakDown;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	

}
