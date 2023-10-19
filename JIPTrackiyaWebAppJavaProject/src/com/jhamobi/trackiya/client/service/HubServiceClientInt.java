package com.jhamobi.trackiya.client.service;

import com.jhamobi.trackiya.client.TrackiyaWebApp.GetAllHubsServiceCallback;
import com.jhamobi.trackiya.client.model.Hub;

public interface HubServiceClientInt {
	
	void addHub(Hub hub);

	void getAllHubs(GetAllHubsServiceCallback cb);
	
}
