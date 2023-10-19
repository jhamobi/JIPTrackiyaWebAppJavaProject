package com.jhamobi.trackiya.client;

public class VehicleRunStatus {
	private final String mVehicleNum;
	private final String mVehicleStatus;
	private final boolean mVehicleRunningStatus;
	private final String mVehicleCurrLoc;
	private final String mVehicleTimeLapsed;
	private final String mDistTravelled;

	public VehicleRunStatus(String vehicleNum, String vehicleStatus, boolean vehicleRunningStatus, String currLoc, String distTravelled, String timeLapsed) {
		this.mVehicleNum = vehicleNum;
		this.mVehicleStatus = vehicleStatus;
		this.mVehicleRunningStatus = vehicleRunningStatus;
		this.mVehicleCurrLoc = currLoc;
		this.mDistTravelled = distTravelled;
		this.mVehicleTimeLapsed = timeLapsed;

	}

	public String getVehicleNum() {
		return mVehicleNum;

	}
	
	public String getVehicleStatus() {
		return mVehicleStatus;

	}

	public boolean getVehicleRunningStatus() {
		return mVehicleRunningStatus;

	}

	public String getVehicleCurrLoc() {
		return mVehicleCurrLoc;

	}
	
	public String getVehicleDistTravelled() {
		return mDistTravelled;

	}

	public String getVehicleTimeLapsed() {
		return mVehicleTimeLapsed;

	}

}
