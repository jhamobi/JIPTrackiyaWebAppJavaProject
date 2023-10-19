package com.jhamobi.trackiya.client;

import static com.jhamobi.trackiya.client.TrackiyaWebApp.hubsMap;

import java.util.Collection;

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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.jhamobi.trackiya.client.model.Hub;
import com.jhamobi.trackiya.client.model.Vehicle;
import com.jhamobi.trackiya.client.service.HubServiceClientImpl;
import com.jhamobi.trackiya.client.service.VehicleServiceClientImpl;

public class VehicleRegWebPage {
	ListBox lbHubIds;
	TextBox tbVehicleType;
	TextBox tbVehicleNum;
	TextBox tbDriverName;
	TextBox tbDriverMobiNum;
	TextBox tbOwnerName;
	TextBox tbOwnerMobiNum;
	TextBox tbWithin1500Rate;
	TextBox tbAbove1500Rate;
	TextBox tbWithin12HrsRate;
	TextBox tbAbove12HrsRate;

	Label lHubId;
	Label lVehicleNum;
	Label lVehicleType;
	Label lDriverName;
	Label lDriverMobiNum;
	Label lOwnerName;
	Label lOwnerMobiNum;
	Label lWithin1500Rate;
	Label lAbove1500Rate;
	Label lWithin12HrsRate;
	Label lAbove12HrsRate;

	HubServiceClientImpl mHubService;
	VehicleServiceClientImpl mVehicleService;
	private Button bRegister;

	public VehicleRegWebPage() {

	}

	public VerticalPanel InitVehicleRegistrationWebPage() {
		VerticalPanel vPanel = new VerticalPanel();
		vPanel.setSpacing(5);

		bRegister = new Button("Register");
		bRegister.setHeight("50px");
		bRegister.setWidth("20%");
		bRegister.setEnabled(false);

		vPanel.setWidth("100%");
		vPanel.setHeight("100%");
		vPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		vPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

		vPanel.add(VehicleHubIdsFields());
		vPanel.add(VehicleInfoFields());
		vPanel.add(DriverInfoFields());
		vPanel.add(OwnerInfoFields());
		vPanel.add(DistanceRateInfoFields());
		vPanel.add(TimeRateInfoFields());
		vPanel.add(bRegister);

		bRegister.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				attemptVehicleRegister();
			}
		});

		return vPanel;

	}

	private HorizontalPanel VehicleHubIdsFields() {

		HorizontalPanel hpVehicleHubInfo = new HorizontalPanel();
		hpVehicleHubInfo.setSpacing(4);

		lHubId = new Label("Hub Id : ");
		lHubId.setWidth("150px");

		// Add a drop box with the list types
		lbHubIds = new ListBox(false);
		lbHubIds.setWidth("500px");
		if (hubsMap != null) {
			Collection<Hub> values = hubsMap.values();
			for (Hub hub : values) {
				lbHubIds.addItem(hub.getId());
			}

			if (hubsMap.size() > 0)
				bRegister.setEnabled(true);
		}

		VerticalPanel dropBoxPanel = new VerticalPanel();
		dropBoxPanel.setSpacing(4);
		dropBoxPanel.add(lbHubIds);

		hpVehicleHubInfo.add(lHubId);
		hpVehicleHubInfo.add(dropBoxPanel);

		return hpVehicleHubInfo;
	}

	private VerticalPanel VehicleInfoFields() {

		VerticalPanel vpVehicleInfo = new VerticalPanel();
		Label lVehicleInfo = new Label("Vehicle Info : ");
		lVehicleInfo.getElement().getStyle().setFontSize(14.0, Unit.PT);
		lVehicleInfo.getElement().getStyle().setFontWeight(FontWeight.BOLD);

		HorizontalPanel hpVehicleInfo = new HorizontalPanel();
		hpVehicleInfo.setSpacing(10);

		HorizontalPanel hpVehicleNum = new HorizontalPanel();
		hpVehicleNum.setSpacing(4);

		lVehicleNum = new Label("Vehicle No. : ");
		lVehicleNum.setWidth("150px");
		tbVehicleNum = new TextBox();

		hpVehicleNum.add(lVehicleNum);
		hpVehicleNum.add(tbVehicleNum);

		HorizontalPanel hpVehicleType = new HorizontalPanel();
		hpVehicleType.setSpacing(4);

		lVehicleType = new Label("Vehicle Type : ");
		lVehicleType.setWidth("150px");
		tbVehicleType = new TextBox();

		hpVehicleType.add(lVehicleType);
		hpVehicleType.add(tbVehicleType);

		hpVehicleInfo.add(hpVehicleNum);
		hpVehicleInfo.add(hpVehicleType);

		vpVehicleInfo.add(lVehicleInfo);
		vpVehicleInfo.add(hpVehicleInfo);

		return vpVehicleInfo;

	}

	private VerticalPanel DriverInfoFields() {

		VerticalPanel vpDriverInfo = new VerticalPanel();
		Label lDriverInfo = new Label("Driver Info : ");
		lDriverInfo.getElement().getStyle().setFontSize(14.0, Unit.PT);
		lDriverInfo.getElement().getStyle().setFontWeight(FontWeight.BOLD);

		HorizontalPanel hpDriverInfo = new HorizontalPanel();
		hpDriverInfo.setSpacing(10);

		HorizontalPanel hpDriverName = new HorizontalPanel();
		hpDriverName.setSpacing(4);

		lDriverName = new Label("Driver Name : ");
		lDriverName.setWidth("150px");
		tbDriverName = new TextBox();

		hpDriverName.add(lDriverName);
		hpDriverName.add(tbDriverName);

		HorizontalPanel hpDriverMobiNum = new HorizontalPanel();
		hpDriverMobiNum.setSpacing(4);

		lDriverMobiNum = new Label("Driver mobile no. : ");
		lDriverMobiNum.setWidth("150px");
		tbDriverMobiNum = new TextBox();

		hpDriverMobiNum.add(lDriverMobiNum);
		hpDriverMobiNum.add(tbDriverMobiNum);

		hpDriverInfo.add(hpDriverName);
		hpDriverInfo.add(hpDriverMobiNum);

		vpDriverInfo.add(lDriverInfo);
		vpDriverInfo.add(hpDriverInfo);

		return vpDriverInfo;

	}

	private VerticalPanel OwnerInfoFields() {

		VerticalPanel vpOwnerInfo = new VerticalPanel();
		Label lOwnerInfo = new Label("Owner Info : ");
		lOwnerInfo.getElement().getStyle().setFontSize(14.0, Unit.PT);
		lOwnerInfo.getElement().getStyle().setFontWeight(FontWeight.BOLD);

		HorizontalPanel hpOwnerInfo = new HorizontalPanel();
		hpOwnerInfo.setSpacing(10);

		HorizontalPanel hpOwnerName = new HorizontalPanel();
		hpOwnerName.setSpacing(4);

		lOwnerName = new Label("Owner Name : ");
		lOwnerName.setWidth("150px");
		tbOwnerName = new TextBox();

		hpOwnerName.add(lOwnerName);
		hpOwnerName.add(tbOwnerName);

		HorizontalPanel hpOwnerMobiNum = new HorizontalPanel();
		hpOwnerMobiNum.setSpacing(4);

		lOwnerMobiNum = new Label("Owner mobile no. : ");
		lOwnerMobiNum.setWidth("150px");
		tbOwnerMobiNum = new TextBox();

		hpOwnerMobiNum.add(lOwnerMobiNum);
		hpOwnerMobiNum.add(tbOwnerMobiNum);

		hpOwnerInfo.add(hpOwnerName);
		hpOwnerInfo.add(hpOwnerMobiNum);

		vpOwnerInfo.add(lOwnerInfo);
		vpOwnerInfo.add(hpOwnerInfo);

		return vpOwnerInfo;

	}

	private VerticalPanel DistanceRateInfoFields() {

		VerticalPanel vpDistRateInfo = new VerticalPanel();
		Label lDistRateInfo = new Label("Distance Rate : ");
		lDistRateInfo.getElement().getStyle().setFontSize(14.0, Unit.PT);
		lDistRateInfo.getElement().getStyle().setFontWeight(FontWeight.BOLD);

		HorizontalPanel hpDistanceRateInfo = new HorizontalPanel();
		hpDistanceRateInfo.setSpacing(10);

		HorizontalPanel hpWithin1500Rate = new HorizontalPanel();
		hpWithin1500Rate.setSpacing(4);

		lWithin1500Rate = new Label("Within 1500 kms : ");
		lWithin1500Rate.setWidth("150px");
		tbWithin1500Rate = new TextBox();

		hpWithin1500Rate.add(lWithin1500Rate);
		hpWithin1500Rate.add(tbWithin1500Rate);

		HorizontalPanel hpAbove1500Rate = new HorizontalPanel();
		hpAbove1500Rate.setSpacing(4);

		lAbove1500Rate = new Label("Above 1500 kms : ");
		lAbove1500Rate.setWidth("150px");
		tbAbove1500Rate = new TextBox();

		hpAbove1500Rate.add(lAbove1500Rate);
		hpAbove1500Rate.add(tbAbove1500Rate);

		hpDistanceRateInfo.add(hpWithin1500Rate);
		hpDistanceRateInfo.add(hpAbove1500Rate);

		vpDistRateInfo.add(lDistRateInfo);
		vpDistRateInfo.add(hpDistanceRateInfo);

		return vpDistRateInfo;

	}

	private VerticalPanel TimeRateInfoFields() {

		VerticalPanel vpHourRateInfo = new VerticalPanel();
		Label lHourRateInfo = new Label("Hour Rate : ");
		lHourRateInfo.getElement().getStyle().setFontSize(14.0, Unit.PT);
		lHourRateInfo.getElement().getStyle().setFontWeight(FontWeight.BOLD);

		HorizontalPanel hpTimeRateInfo = new HorizontalPanel();
		hpTimeRateInfo.setSpacing(10);

		HorizontalPanel hpWithin12HrsRate = new HorizontalPanel();
		hpWithin12HrsRate.setSpacing(4);

		lWithin12HrsRate = new Label("Within 12 hrs : ");
		lWithin12HrsRate.setWidth("150px");
		tbWithin12HrsRate = new TextBox();

		hpWithin12HrsRate.add(lWithin12HrsRate);
		hpWithin12HrsRate.add(tbWithin12HrsRate);

		HorizontalPanel hpAbove12HrsRate = new HorizontalPanel();
		hpAbove12HrsRate.setSpacing(4);

		lAbove12HrsRate = new Label("Above 12 hrs : ");
		lAbove12HrsRate.setWidth("150px");
		tbAbove12HrsRate = new TextBox();

		hpAbove12HrsRate.add(lAbove12HrsRate);
		hpAbove12HrsRate.add(tbAbove12HrsRate);

		hpTimeRateInfo.add(hpWithin12HrsRate);
		hpTimeRateInfo.add(hpAbove12HrsRate);

		vpHourRateInfo.add(lHourRateInfo);
		vpHourRateInfo.add(hpTimeRateInfo);

		return vpHourRateInfo;

	}

	public void attemptVehicleRegister() {

		boolean required = false;

		if (lbHubIds.getItemCount() == 0) {
			lHubId.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbVehicleNum.getText().isEmpty()) {
			lVehicleNum.setStyleName("gwt-Red-Text");
			required = true;
		}
		if (tbVehicleType.getText().isEmpty()) {
			lVehicleType.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbDriverName.getText().isEmpty()) {
			lDriverName.setStyleName("gwt-Red-Text");
			required = true;
		}
		if (tbDriverMobiNum.getText().isEmpty()) {
			lDriverMobiNum.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbOwnerName.getText().isEmpty()) {
			lOwnerName.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbOwnerMobiNum.getText().isEmpty()) {
			lOwnerMobiNum.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbWithin1500Rate.getText().isEmpty()) {
			lWithin1500Rate.setStyleName("gwt-Red-Text");
			required = true;
		}
		if (tbAbove1500Rate.getText().isEmpty()) {
			lAbove1500Rate.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbWithin12HrsRate.getText().isEmpty()) {
			lWithin12HrsRate.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (tbAbove12HrsRate.getText().isEmpty()) {
			lAbove12HrsRate.setStyleName("gwt-Red-Text");
			required = true;
		}

		if (required == false) {
			Vehicle newVehicle = new Vehicle();
			newVehicle.setId(tbVehicleNum.getText());
			newVehicle.setType(tbVehicleType.getText());
			newVehicle.setNumber(tbVehicleNum.getText());
			newVehicle.setDriverName(tbDriverName.getText());
			newVehicle.setDriverPhNumber(tbDriverMobiNum.getText());
			newVehicle.setOwnerName(tbOwnerName.getText());
			newVehicle.setOwnerPhoneNumber(tbOwnerMobiNum.getText());
			newVehicle.setRateWithin1500Km(tbWithin1500Rate.getText());
			newVehicle.setRateAbove1500Km(tbAbove1500Rate.getText());
			newVehicle.setRateWithin12Hrs(tbWithin12HrsRate.getText());
			newVehicle.setRateAbove12Hrs(tbAbove12HrsRate.getText());

			VehicleServiceClientImpl clientService = new VehicleServiceClientImpl(GWT.getModuleBaseURL()
					+ "vehicleService");
			try {
				newVehicle.setHub(hubsMap.get(lbHubIds.getValue(lbHubIds.getSelectedIndex())));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				clientService.addVehicle(newVehicle);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void refreshData() {
		if (hubsMap != null) {
			Collection<Hub> values = hubsMap.values();
			for (Hub hub : values) {
				lbHubIds.addItem(hub.getId());
			}
			if (hubsMap.size() > 0)
				bRegister.setEnabled(true);
		}
		return;
	}

}
