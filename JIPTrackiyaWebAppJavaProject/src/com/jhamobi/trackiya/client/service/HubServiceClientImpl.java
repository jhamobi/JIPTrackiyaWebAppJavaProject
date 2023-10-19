package com.jhamobi.trackiya.client.service;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.jhamobi.trackiya.client.TrackiyaWebApp.GetAllHubsServiceCallback;
import com.jhamobi.trackiya.client.TrackiyaWebApp.GetAllVehicleTrackingDataServiceCallback;
import com.jhamobi.trackiya.client.TrackiyaWebApp.GetAllVehiclesServiceCallback;
import com.jhamobi.trackiya.client.model.Hub;
import com.jhamobi.trackiya.client.model.RunningData;
import com.jhamobi.trackiya.client.model.TrackingData;
import com.jhamobi.trackiya.client.model.Vehicle;

public class HubServiceClientImpl implements HubServiceClientInt {
	
	private HubServiceAsync service;

	public HubServiceClientImpl(String url) {

		this.service = GWT.create(HubService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(url);
		
	}

	@Override
	public void addHub(Hub hub) {
		this.service.addHub(hub, new AddHubServiceCallback());		
	}


	
	public class AddHubServiceCallback implements AsyncCallback<Void> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Server Exception: " + caught.getMessage());
		}

		@Override
		public void onSuccess(Void result) {
			Window.alert("Vehicle Successfully added");
		}

	}


	public void getAllHubs(GetAllHubsServiceCallback getAllHubsServiceCallback) {
		// TODO Auto-generated method stub
		
	}
	
	
	}

