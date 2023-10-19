package com.jhamobi.trackiya.server.tomcat.servlet;


import java.sql.Connection;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jhamobi.trackiya.client.ServerException;
import com.jhamobi.trackiya.client.model.Hub;
import com.jhamobi.trackiya.client.service.HubService;
import com.jhamobi.trackiya.server.database.TrackiyaMySqlDBConnection;
import com.jhamobi.trackiya.server.tomcat.TrackiyaConstants;

public class HubServiceImpl extends RemoteServiceServlet implements HubService {

	private static final long serialVersionUID = 1L;

	@Override
	public void addHub(Hub hub) throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			dbConnection.addHub(connection, hub);
		} catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while adding hub", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}  finally {
			dbConnection.closeDBConnection(connection);
		}

	}

	@Override
	public List<Hub> getHubs() throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			List<Hub> hubs = dbConnection.getHubs(connection);
			
			return hubs;
		} catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching hubs", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}  finally {
			dbConnection.closeDBConnection(connection);
		}
	}

}
