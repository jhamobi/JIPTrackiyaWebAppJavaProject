package com.jhamobi.trackiya.client.service;

import java.util.List;

import com.jhamobi.trackiya.client.model.RunningData;
import com.jhamobi.trackiya.client.model.TrackingData;
import com.jhamobi.trackiya.client.model.Vehicle;

public interface VehicleServiceClientInt {

	void addVehicle(Vehicle v) throws Exception;

	List<Vehicle> fetchVehiclesWithTrackingData(String hubId) throws Exception;

	RunningData fetchRunningDataForVehicle(String vehicleId) throws Exception;

	TrackingData fetchTrackingDataForVehicle(String vehicleId) throws Exception;
	
	void fetchAllVehiclesWithDetails() throws Exception;
	
	void fetchAllVehiclesWithTrackingData() throws Exception;


}
