package com.jhamobi.trackiya.client;

import static com.jhamobi.trackiya.client.TrackiyaWebApp.hubsMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jhamobi.trackiya.client.model.Hub;
import com.jhamobi.trackiya.client.service.HubServiceClientImpl;

public class HubRegWebPage {
	TextBox tbHubId;
	TextBox tbHubName;
	TextBox tbInchargeName;
	TextBox tbInchargeMailId;
	TextBox tbInchargePhNo;
	TextBox tbHubLongi;
	TextBox tbHubLati;
	TextBox tbHubCity;
	TextBox tbHubZone;
	TextBox tbHubAddress;

	Label lHubId;
	Label lHubName;
	Label lInchargeName;
	Label lInchargeMailId;
	Label lInchargePhNo;
	Label lHubCity;
	Label lHubZone;
	Label lHubLongi;
	Label lHubLati;
	Label lHubAddress;

	List<HubDetail> hubList;

	public HubRegWebPage() {
	}

	public VerticalPanel InitHubRegistrationWebPage() {
		if (hubsMap != null) {
			hubList = new ArrayList<HubDetail>();
			Collection<Hub> values = hubsMap.values();
			for (Hub hub : values) {
				HubDetail hubDetail = new HubDetail(hub.getId(), hub.getName(), hub.getCity(), hub.getZone(),
						hub.getAddress());
				hubList.add(hubDetail);
			}
		}

		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setSpacing(5);

		Button bRegister = new Button("Register");
		bRegister.setHeight("50px");
		bRegister.setWidth("20%");

		vPanel.setWidth("100%");
		vPanel.setHeight("100%");
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		vPanel.add(HubInfoFields());
		vPanel.add(HubLocFields());
		vPanel.add(bRegister);

		bRegister.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				attemptHubRegister();

			}
		});
		return vPanel;
	}

	public void attemptHubRegister() {

		boolean required = false;

		if (tbHubId.getText().isEmpty()) {
			lHubId.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbHubName.getText().isEmpty()) {
			lHubName.setStyleName("gwt-Red-Text");
			required = true;
		}
		if (tbInchargeName.getText().isEmpty()) {
			lInchargeName.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbInchargeMailId.getText().isEmpty()) {
			lInchargeMailId.setStyleName("gwt-Red-Text");
			required = true;
		}
		if (tbInchargePhNo.getText().isEmpty()) {
			lInchargePhNo.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbHubCity.getText().isEmpty()) {
			lHubCity.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbHubZone.getText().isEmpty()) {
			lHubZone.setStyleName("gwt-Red-Text");
			required = true;
		}
		if (tbHubLongi.getText().isEmpty()) {
			lHubLongi.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbHubLati.getText().isEmpty()) {
			lHubLati.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbHubAddress.getText().isEmpty()) {
			lHubAddress.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (required == false) {
			Hub newHub = new Hub();
			newHub.setId(tbHubId.getText());
			newHub.setName(tbHubName.getText());
			newHub.setLongitude(Double.valueOf(tbHubLongi.getText()));
			newHub.setLatitude(Double.valueOf(tbHubLati.getText()));
			newHub.setCity(tbHubCity.getText());
			newHub.setZone(tbHubZone.getText());
			newHub.setAddress(tbHubAddress.getText());

			HubServiceClientImpl clientService = new HubServiceClientImpl(GWT.getModuleBaseURL() + "hubService");
			clientService.addHub(newHub);
		}
	}

	private VerticalPanel HubInfoFields() {

		VerticalPanel vpHubInfo = new VerticalPanel();
		Label lHubInfo = new Label("Hub Info : ");
		lHubInfo.getElement().getStyle().setFontSize(14.0, Unit.PT);
		lHubInfo.getElement().getStyle().setFontWeight(FontWeight.BOLD);

		HorizontalPanel hpHubInfo = new HorizontalPanel();
		hpHubInfo.setSpacing(10);

		HorizontalPanel hpHubId = new HorizontalPanel();
		hpHubId.setSpacing(4);

		lHubId = new Label("Hub Id : ");
		lHubId.setWidth("150px");
		tbHubId = new TextBox();

		hpHubId.add(lHubId);
		hpHubId.add(tbHubId);

		HorizontalPanel hpHubName = new HorizontalPanel();
		hpHubName.setSpacing(4);

		lHubName = new Label("Hub Name : ");
		lHubName.setWidth("150px");
		tbHubName = new TextBox();

		hpHubName.add(lHubName);
		hpHubName.add(tbHubName);

		hpHubInfo.add(hpHubId);
		hpHubInfo.add(hpHubName);

		HorizontalPanel hpHubInfo1 = new HorizontalPanel();
		hpHubInfo1.setSpacing(10);

		HorizontalPanel hpHubCity = new HorizontalPanel();
		hpHubCity.setSpacing(4);

		lHubCity = new Label("Hub City : ");
		lHubCity.setWidth("150px");
		tbHubCity = new TextBox();

		hpHubCity.add(lHubCity);
		hpHubCity.add(tbHubCity);

		HorizontalPanel hpHubZone = new HorizontalPanel();
		hpHubZone.setSpacing(4);

		lHubZone = new Label("Hub Zone : ");
		lHubZone.setWidth("150px");
		tbHubZone = new TextBox();

		hpHubZone.add(lHubZone);
		hpHubZone.add(tbHubZone);

		hpHubInfo1.add(hpHubCity);
		hpHubInfo1.add(hpHubZone);

		vpHubInfo.add(lHubInfo);
		vpHubInfo.add(hpHubInfo);
		vpHubInfo.add(hpHubInfo1);

		return vpHubInfo;

	}

	private VerticalPanel HubLocFields() {

		VerticalPanel vpHubLocInfo = new VerticalPanel();
		Label lHubLocInfo = new Label("Hub Location : ");
		lHubLocInfo.getElement().getStyle().setFontSize(14.0, Unit.PT);
		lHubLocInfo.getElement().getStyle().setFontWeight(FontWeight.BOLD);

		HorizontalPanel hpHubLoc = new HorizontalPanel();
		hpHubLoc.setSpacing(10);

		HorizontalPanel hpHubLongi = new HorizontalPanel();
		hpHubLongi.setSpacing(4);

		lHubLongi = new Label("Hub Longitude : ");
		lHubLongi.setWidth("150px");
		tbHubLongi = new TextBox();

		hpHubLongi.add(lHubLongi);
		hpHubLongi.add(tbHubLongi);

		HorizontalPanel hpHubLati = new HorizontalPanel();
		hpHubLati.setSpacing(4);

		lHubLati = new Label("Hub Latitude : ");
		lHubLati.setWidth("150px");
		tbHubLati = new TextBox();

		hpHubLati.add(lHubLati);
		hpHubLati.add(tbHubLati);

		hpHubLoc.add(hpHubLati);
		hpHubLoc.add(hpHubLongi);

		HorizontalPanel hpHubLoc1 = new HorizontalPanel();
		hpHubLoc1.setSpacing(10);

		HorizontalPanel hpHubAddress = new HorizontalPanel();
		hpHubAddress.setSpacing(4);

		lHubAddress = new Label("Hub Address : ");
		lHubAddress.setWidth("150px");
		tbHubAddress = new TextBox();
		tbHubAddress.setWidth("500px");

		hpHubLoc1.add(lHubAddress);
		hpHubLoc1.add(tbHubAddress);

		vpHubLocInfo.add(lHubLocInfo);
		vpHubLocInfo.add(hpHubLoc);
		vpHubLocInfo.add(hpHubLoc1);

		return vpHubLocInfo;

	}
}
