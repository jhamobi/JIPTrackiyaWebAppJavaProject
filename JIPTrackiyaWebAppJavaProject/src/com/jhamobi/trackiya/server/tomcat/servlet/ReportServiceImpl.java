package com.jhamobi.trackiya.server.tomcat.servlet;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.jhamobi.trackiya.client.model.DailyReport;
import com.jhamobi.trackiya.client.service.ReportService;

public class ReportServiceImpl extends RemoteServiceServlet implements ReportService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public DailyReport getDailyReport() throws Exception {
		new GeneratePDFDailyReport ();
		return null;

	}
}
