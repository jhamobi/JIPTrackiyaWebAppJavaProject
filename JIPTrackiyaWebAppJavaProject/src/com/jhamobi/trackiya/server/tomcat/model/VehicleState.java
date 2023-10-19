package com.jhamobi.trackiya.server.tomcat.model;
public enum VehicleState {
	WAKEUP(1),
	REPORTED(2),
	STARTED(3),
	END(4),
	RELEASED(5),
	BREAKDOWN(6);
	  private int state;
	  private VehicleState(int s){
		  this.state = s;
	  }
	  
	  public int getState() {
		return state;
	  }
	  
	 public static VehicleState getVehicleState(int state){
		  VehicleState[] values = VehicleState.values();
		  for (VehicleState vehicleState : values) {
			if(vehicleState.getState() == state)
				return vehicleState;
		}
		  
		  return null;
	  }
}