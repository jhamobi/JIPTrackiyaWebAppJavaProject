package com.jhamobi.trackiya.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.jhamobi.trackiya.client.model.DailyReport;

public class ReportServiceClientImpl implements ReportServiceClientInt {

	private ReportServiceAsync service;

	public ReportServiceClientImpl(String url) {

		this.service = GWT.create(ReportService.class);
		ServiceDefTarget serviceDef = (ServiceDefTarget) service;
		serviceDef.setServiceEntryPoint(url);

	}

	@Override
	public void getDailyReport() throws Exception {
		this.service.getDailyReport(new DailyReportServiceCallback());		

	}
	
	public class DailyReportServiceCallback implements AsyncCallback<DailyReport> {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Server Exception: " + caught.getMessage());
		}

		@Override
		public void onSuccess(DailyReport result) {
			Window.alert("Daily report generated");

		}

	}

}
