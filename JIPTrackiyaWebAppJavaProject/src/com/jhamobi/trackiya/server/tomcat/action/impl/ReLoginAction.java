package com.jhamobi.trackiya.server.tomcat.action.impl;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.jhamobi.trackiya.client.model.Vehicle;
import com.jhamobi.trackiya.server.database.TrackiyaDBTableColumnNames;
import com.jhamobi.trackiya.server.database.TrackiyaMySqlDBConnection;
import com.jhamobi.trackiya.server.tomcat.TrackiyaConstants;
import com.jhamobi.trackiya.server.tomcat.action.TrackiyaServerErrorType;
import com.jhamobi.trackiya.server.tomcat.action.TrackiyaServerErrors;

/**
 * 
 * @author majha
 * 
 */
public class ReLoginAction extends
		com.jhamobi.trackiya.server.tomcat.action.AbstractAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			PrintWriter out = response.getWriter();
			JSONObject jsonResponse = new JSONObject();

			try {
				HttpSession session = request.getSession();

				ServletInputStream inputStream = request.getInputStream();
				String requestJson = convertStreamToString(inputStream);
				// A Simple JSONObject Creation
				JSONObject jsonRequest = new JSONObject(requestJson);

				String id = jsonRequest
						.getString(TrackiyaDBTableColumnNames.VEHICLE_ID);
				// String password = jsonRequest.getString(USERS_PASSWORD);

				TrackiyaMySqlDBConnection instaBuddyDBConnection = TrackiyaMySqlDBConnection
						.getInstance();
				Connection dbConnection = instaBuddyDBConnection
						.getDBConnection();
				try {
					if (id != null) {
						Vehicle v = instaBuddyDBConnection.getVehicle(
								dbConnection, id);
						if (v != null) {
								session.setAttribute(TrackiyaConstants.VEHICLE,
										v);

								jsonResponse.put(TrackiyaConstants.SUCCESS,
										true);							
						} else {
							jsonResponse
									.put(TrackiyaConstants.SUCCESS, false);
							jsonResponse
									.put(TrackiyaConstants.ERROR_TYPE,
											TrackiyaServerErrorType.VEHICLE_ID_DOES_NOT_EXIST);
							jsonResponse
									.put(TrackiyaConstants.ERROR,
											TrackiyaServerErrors.VEHICLE_ID_DOES_NOT_EXIST);
						}
					}
					else if (id == null || id.trim().isEmpty()) {
						jsonResponse.put(TrackiyaConstants.SUCCESS, false);
						jsonResponse.put(TrackiyaConstants.ERROR_TYPE,
								TrackiyaServerErrorType.INVALID_VEHICLE_ID);
						jsonResponse.put(TrackiyaConstants.ERROR,
								TrackiyaServerErrors.INVALID_VEHICLE_ID);
					}
				} catch (Exception e) {
					jsonResponse.put(TrackiyaConstants.SUCCESS, false);
					jsonResponse.put(TrackiyaConstants.ERROR_TYPE,
							TrackiyaServerErrorType.SERVER_EXCEPTION);
					jsonResponse.put(TrackiyaConstants.ERROR, e.getMessage());

					TrackiyaConstants.LOGGER
							.error("Error in login action", e);
				} finally {
					instaBuddyDBConnection.closeDBConnection(dbConnection);
				}
			} catch (Exception e) {
				jsonResponse.put(TrackiyaConstants.SUCCESS, false);
				jsonResponse.put(TrackiyaConstants.ERROR_TYPE,
						TrackiyaServerErrorType.SERVER_EXCEPTION);
				jsonResponse.put(TrackiyaConstants.ERROR, e.getMessage());

				TrackiyaConstants.LOGGER.error("Error in login action", e);
			}

			try {
				out.print(jsonResponse.toString());
			} finally {
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			TrackiyaConstants.LOGGER.error("Error in login action", e);
		}

	}

}
