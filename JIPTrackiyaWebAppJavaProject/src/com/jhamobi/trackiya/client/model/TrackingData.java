package com.jhamobi.trackiya.client.model;

import java.io.Serializable;

public class TrackingData implements Serializable{

	private static final long serialVersionUID = 1L;

	private String date;
	private String reportTime;
	private String startTime;
	private String endTime;
	private String releasetime;
	private RunningData runningData;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public RunningData getRunningData() {
		return runningData;
	}
	public void setRunningData(RunningData runningData) {
		this.runningData = runningData;
	}
	
	
}
