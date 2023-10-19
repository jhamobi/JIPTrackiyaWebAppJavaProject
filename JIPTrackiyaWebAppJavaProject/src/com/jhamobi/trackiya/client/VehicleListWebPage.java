package com.jhamobi.trackiya.client;

import static com.jhamobi.trackiya.client.TrackiyaWebApp.vehicleList;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.jhamobi.trackiya.client.model.Vehicle;

public class VehicleListWebPage {
	List<VehicleDetail> vehicleDetailList;
	private CellTable<VehicleDetail> table;

	public VehicleListWebPage() {
	}

	public CellTable<VehicleDetail> InitVehicleListWebPage() {
		vehicleDetailList = new ArrayList<VehicleDetail>();
		if (vehicleList != null) {
			for (Vehicle vehicle : vehicleList) {
				VehicleDetail vehicleDetail = new VehicleDetail(vehicle.getId(), vehicle.getType(),
						vehicle.getDriverName(), vehicle.getDriverPhNumber(), vehicle.getOwnerName(),
						vehicle.getOwnerPhoneNumber(), vehicle.getRateWithin1500Km(), vehicle.getRateAbove1500Km(),
						vehicle.getRateWithin12Hrs(), vehicle.getRateAbove12Hrs());
				vehicleDetailList.add(vehicleDetail);
			}
		}

		// Create a CellTable.
		 table = new CellTable<VehicleDetail>();
		table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		// Add a text column to show the name.
		TextColumn<VehicleDetail> vehicleNum = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getVehicleNum();
			}
		};
		table.addColumn(vehicleNum, "Vehicle No.");

		// Add a text column to show the name.
		TextColumn<VehicleDetail> vehicleType = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getVehicleType();
			}
		};
		table.addColumn(vehicleType, "Vehicle Type");

		TextColumn<VehicleDetail> driverName = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getDriverName();
			}
		};
		table.addColumn(driverName, "Driver Name");

		TextColumn<VehicleDetail> driverNum = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getDriverNum();
			}
		};
		table.addColumn(driverNum, "Driver Number");

		TextColumn<VehicleDetail> ownerName = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getOwnerName();
			}
		};
		table.addColumn(ownerName, "Owner Name");

		TextColumn<VehicleDetail> ownerNum = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getOwnerNum();
			}
		};
		table.addColumn(ownerNum, "Owner Number");

		// Add a text column to show the name.
		TextColumn<VehicleDetail> rateWithin1500Km = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getRateWithin1500Km();
			}
		};
		table.addColumn(rateWithin1500Km, "within 1500 km");

		// Add a text column to show the name.
		TextColumn<VehicleDetail> rateAbove1500Km = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getRateAbove1500Km();
			}
		};
		table.addColumn(rateAbove1500Km, "above 1500 km");

		// Add a text column to show the name.
		TextColumn<VehicleDetail> rateWithin12Hr = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getRateWithin12Hrs();
			}
		};
		table.addColumn(rateWithin12Hr, "within 12 hrs");

		// Add a text column to show the name.
		TextColumn<VehicleDetail> rateAbove12Hr = new TextColumn<VehicleDetail>() {
			@Override
			public String getValue(VehicleDetail object) {
				return object.getRateAbove12Hrs();
			}
		};
		table.addColumn(rateAbove12Hr, "above 12 hrs");

		// Set the total row count. This isn't strictly necessary, but it
		// affects
		// paging calculations, so its good habit to keep the row count up to
		// date.
		table.setRowCount(vehicleDetailList.size(), true);

		// Push the data into the widget.
		table.setRowData(0, vehicleDetailList);

		return table;
	}

	public void refreshData() {

		if (vehicleList != null) {
			vehicleDetailList = new ArrayList<VehicleDetail>();
			for (Vehicle vehicle : vehicleList) {
				VehicleDetail vehicleDetail = new VehicleDetail(vehicle.getId(), vehicle.getType(),
						vehicle.getDriverName(), vehicle.getDriverPhNumber(), vehicle.getOwnerName(),
						vehicle.getOwnerPhoneNumber(), vehicle.getRateWithin1500Km(), vehicle.getRateAbove1500Km(),
						vehicle.getRateWithin12Hrs(), vehicle.getRateAbove12Hrs());
				vehicleDetailList.add(vehicleDetail);
			}
			table.setRowCount(vehicleDetailList.size(), true);

			// Push the data into the widget.
			table.setRowData(0, vehicleDetailList);
		}
		
		
		
	}
}
