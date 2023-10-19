package com.jhamobi.trackiya.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.jhamobi.trackiya.client.model.DailyReport;

@RemoteServiceRelativePath("reportService")
public interface ReportService extends RemoteService{
	
	public DailyReport getDailyReport() throws Exception;

}
