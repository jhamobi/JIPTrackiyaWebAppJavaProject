package com.jhamobi.trackiya.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.jhamobi.trackiya.client.model.Hub;

public interface HubServiceAsync {

	void addHub(Hub hub, AsyncCallback<Void> callback);

	void getHubs(AsyncCallback<List<Hub>> callback);

}
