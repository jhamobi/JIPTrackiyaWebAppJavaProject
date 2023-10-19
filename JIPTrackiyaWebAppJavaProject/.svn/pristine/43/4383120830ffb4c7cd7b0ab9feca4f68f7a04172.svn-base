package com.jhamobi.trackiya.server.tomcat.action.impl;

import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jhamobi.trackiya.client.model.RunningData;
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
public class UpdatingRunningDataAction extends
		com.jhamobi.trackiya.server.tomcat.action.AbstractAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {

			PrintWriter out = response.getWriter();
			JSONObject jsonResponse = new JSONObject();

			try {
				ServletInputStream inputStream = request.getInputStream();
				String requestJson = convertStreamToString(inputStream);
				// A Simple JSONObject Creation
				JSONObject jsonRequest = new JSONObject(requestJson);

				String id = jsonRequest
						.getString(TrackiyaDBTableColumnNames.VEHICLE_ID);
				boolean isBreakDown=jsonRequest
						.getBoolean(TrackiyaDBTableColumnNames.BREAK_DOWN);
				boolean isRunning=jsonRequest
						.getBoolean(TrackiyaDBTableColumnNames.RUNNING_STATUS);
				String currentAddress=jsonRequest
						.getString(TrackiyaDBTableColumnNames.ADDRESS);
				String distanceTravelled=jsonRequest
						.getString(TrackiyaDBTableColumnNames.DISTANCE_TRAVELLED);
				String timeTravelled=jsonRequest
						.getString(TrackiyaDBTableColumnNames.TIME_TRAVELLED);
				String time=jsonRequest
						.getString(TrackiyaDBTableColumnNames.TIME);
				double latitude=jsonRequest
						.getDouble(TrackiyaDBTableColumnNames.LATITUTE);
				double longitude=jsonRequest
						.getDouble(TrackiyaDBTableColumnNames.LONGITUDE);
				
				RunningData runningData = new RunningData();
				runningData.setBreakDown(isBreakDown);
				runningData.setCurrentAddress(currentAddress);
				runningData.setDistanceTravelled(distanceTravelled);
				runningData.setLatitute(latitude);
				runningData.setLongitude(longitude);
				runningData.setRunning(isRunning);
				runningData.setTime(time);
				runningData.setTimeTravelled(timeTravelled);

				TrackiyaMySqlDBConnection instaBuddyDBConnection = TrackiyaMySqlDBConnection
						.getInstance();
				Connection dbConnection = instaBuddyDBConnection
						.getDBConnection();
				try {
					if (id != null) {
						boolean exist = instaBuddyDBConnection.isReportTimeInsertedForToday(dbConnection, id);
						if(exist){
							instaBuddyDBConnection.updateRunningData(dbConnection, id, runningData);
							jsonResponse.put(TrackiyaConstants.SUCCESS, true);
						}
						else{
							jsonResponse.put(TrackiyaConstants.SUCCESS, false);
							jsonResponse.put(TrackiyaConstants.ERROR_TYPE,
									TrackiyaServerErrorType.MISSING_REPORT_TIME);
							jsonResponse.put(TrackiyaConstants.ERROR,
									TrackiyaServerErrors.MISSING_REPORT_TIME);
						}
					}else if (id == null || id.trim().isEmpty()) {
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
