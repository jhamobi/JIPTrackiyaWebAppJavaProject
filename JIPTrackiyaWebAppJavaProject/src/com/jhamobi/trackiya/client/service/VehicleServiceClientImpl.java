package com.jhamobi.trackiya.client.service;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.jhamobi.trackiya.client.TrackiyaWebApp.GetAllVehicleTrackingDataServiceCallback;
import com.jhamobi.trackiya.client.TrackiyaWebApp.GetAllVehiclesServiceCallback;
import com.jhamobi.trackiya.client.model.Hub;
import com.jhamobi.trackiya.client.model.RunningData;
import com.jhamobi.trackiya.client.model.TrackingData;
import com.jhamobi.trackiya.client.model.Vehicle;

public class VehicleServiceClientImpl implements VehicleServiceClientInt {
	
	private VehicleServiceAsync service;

	public VehicleServiceClientImpl(String url) {

		this.service = GWT.create(VehicleService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(url);
		
	}

	@Override
	public void addVehicle(Vehicle vehicle) throws Exception {
		this.service.addVehicle(vehicle, new AddVehicleServiceCallback());		
	}
	
	@Override
	public void fetchAllVehiclesWithDetails() {
		this.service.fetchAllVehiclesWithDetails(new GetAllVehicleServiceCallback());
		
	}
	
	public void fetchAllVehicles(GetAllVehiclesServiceCallback getAllHubsServiceCallback) throws Exception {
		this.service.fetchAllVehiclesWithDetails(getAllHubsServiceCallback);
		
	}
	
	@Override
	public void fetchAllVehiclesWithTrackingData() {
		this.service.fetchAllVehiclesWithDetails(new GetAllVehicleTrackingDataCallback());
		
	}
	
	public void fetchAllVehiclesTrackingData(GetAllVehicleTrackingDataServiceCallback getAllVehicleTrackingDataServiceCallback) throws Exception {
		this.service.fetchAllVehiclesWithTrackingData(getAllVehicleTrackingDataServiceCallback);
		
	}
	
	@Override
	public List<Vehicle> fetchVehiclesWithTrackingData(String hubId) throws Exception {
		this.service.fetchVehiclesWithTrackingData(hubId, new fetchVehiclesWithTrackingDataServiceCallback());		
		return null;
	}

	@Override
	public RunningData fetchRunningDataForVehicle(String vehicleId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrackingData fetchTrackingDataForVehicle(String vehicleId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public class AddVehicleServiceCallback implements AsyncCallback<Void> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Server Exception: " + caught.getMessage());
		}

		@Override
		public void onSuccess(Void result) {
			Window.alert("Vehicle Successfully added");
		}

	}
	
	public class fetchVehiclesWithTrackingDataServiceCallback implements AsyncCallback<List<Vehicle>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Server Exception: " + caught.getMessage());
		}

		@Override
		public void onSuccess(List<Vehicle> result) {
			Window.alert("Vehicle list loaded");
		}
	}
	
	public class GetAllVehicleServiceCallback implements AsyncCallback<List<Vehicle>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Server Exception: " + caught.getMessage());
		}

		@Override
		public void onSuccess(List<Vehicle> result) {
			int size = result.size();
			GWT.log(String.valueOf(size), null);
		}
	}

	public class GetAllVehicleTrackingDataCallback implements AsyncCallback<List<Vehicle>> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Server Exception: " + caught.getMessage());
		}

		@Override
		public void onSuccess(List<Vehicle> result) {
			int size = result.size();
			GWT.log(String.valueOf(size), null);
		}
	}

	
}
