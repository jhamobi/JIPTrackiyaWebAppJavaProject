package com.jhamobi.trackiya.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jhamobi.trackiya.client.model.RunningData;
import com.jhamobi.trackiya.client.model.TrackingData;
import com.jhamobi.trackiya.client.model.Vehicle;

@RemoteServiceRelativePath("vehicleService")
public interface VehicleService extends RemoteService {

	public void addVehicle(Vehicle v) throws Exception;
	
	public List<Vehicle> fetchVehiclesWithTrackingData(String hubId) throws Exception;
	
	public List<Vehicle> fetchAllVehiclesWithTrackingData() throws Exception;
	
	public List<Vehicle> fetchVehiclesWithDetails(String hubId) throws Exception;
	
	public List<Vehicle> fetchAllVehiclesWithDetails() throws Exception;
	

	public RunningData fetchRunningDataForVehicle(String vehicleId) throws Exception;

	public TrackingData fetchTrackingDataForVehicle(String vehicleId) throws Exception;
	
	public Vehicle getVehicleDetail(String vehicleId) throws Exception;
}
