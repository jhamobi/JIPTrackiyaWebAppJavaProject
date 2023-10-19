package com.jhamobi.trackiya.client.model;

import java.io.Serializable;

public class DailyReport implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7082568541020957487L;
	private String mReportDate;
	
	public DailyReport() {
	}

	public DailyReport(String reportDate) {
		this.mReportDate = reportDate;
	}
	
	public String getReportDate(){
		return mReportDate;
		
	}

}
