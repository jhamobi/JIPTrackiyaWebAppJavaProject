package com.jhamobi.trackiya.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jhamobi.trackiya.client.model.Hub;

@RemoteServiceRelativePath("hubService")
public interface HubService extends RemoteService {

	public void addHub(Hub hub) throws Exception;
	
	public List<Hub> getHubs() throws Exception;
}
