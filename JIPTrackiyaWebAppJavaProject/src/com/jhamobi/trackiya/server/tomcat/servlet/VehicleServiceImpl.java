package com.jhamobi.trackiya.server.tomcat.servlet;

import java.sql.Connection;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jhamobi.trackiya.client.ServerException;
import com.jhamobi.trackiya.client.model.RunningData;
import com.jhamobi.trackiya.client.model.TrackingData;
import com.jhamobi.trackiya.client.model.Vehicle;
import com.jhamobi.trackiya.client.service.VehicleService;
import com.jhamobi.trackiya.server.database.TrackiyaMySqlDBConnection;
import com.jhamobi.trackiya.server.tomcat.TrackiyaConstants;

public class VehicleServiceImpl extends RemoteServiceServlet implements
		VehicleService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void addVehicle(Vehicle v) throws Exception{
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			dbConnection.addVehicle(connection, v);
		}   catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while adding vehicle", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
	}

	@Override
	public List<Vehicle> fetchVehiclesWithTrackingData(String hubId) throws Exception{
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			List<Vehicle> vehicles = dbConnection.getVehicles(connection, hubId);
			for (Vehicle vehicle : vehicles) {
				vehicle.setTrackingData(dbConnection.getTrackingdata(connection, vehicle.getId()));
			}
			return vehicles;
		}   catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching vehicles running data ", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
	}

	@Override
	public RunningData fetchRunningDataForVehicle(String vehicleId) throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			return dbConnection.getRunningData(connection, vehicleId);
		} catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching running data for Vehicle", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
		
	}
	
	@Override
	public TrackingData fetchTrackingDataForVehicle(String vehicleId) throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			return dbConnection.getTrackingdata(connection, vehicleId);
		} catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching tracking data for Vehicle", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
		
	}

	@Override
	public List<Vehicle> fetchAllVehiclesWithTrackingData() throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			List<Vehicle> vehicles = dbConnection.getAllVehicles(connection);
			for (Vehicle vehicle : vehicles) {
				vehicle.setTrackingData(dbConnection.getTrackingdata(connection, vehicle.getId()));
			}
			return vehicles;
		}   catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching all vehicles running data ", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
	}

	@Override
	public List<Vehicle> fetchVehiclesWithDetails(String hubId)
			throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			List<Vehicle> vehicles = dbConnection.getVehicles(connection, hubId);
			return vehicles;
		}   catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching vehicles for  hub ", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
	}

	@Override
	public List<Vehicle> fetchAllVehiclesWithDetails() throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			List<Vehicle> vehicles = dbConnection.getAllVehicles(connection);
			return vehicles;
		}   catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching all vehicles ", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
	}

	@Override
	public Vehicle getVehicleDetail(String vehicleId) throws Exception {
		TrackiyaMySqlDBConnection dbConnection = TrackiyaMySqlDBConnection
				.getInstance();
		Connection connection = dbConnection.getDBConnection();
		try {
			Vehicle vehicle = dbConnection.getVehicle(connection, vehicleId);
			return vehicle;
		}   catch(Exception e){ 
			TrackiyaConstants.LOGGER.error("error while fetching all vehicles ", e);
			throw new ServerException(e.getMessage(), e.getCause());
		}finally {
			dbConnection.closeDBConnection(connection);
		}
	}
	
	



}