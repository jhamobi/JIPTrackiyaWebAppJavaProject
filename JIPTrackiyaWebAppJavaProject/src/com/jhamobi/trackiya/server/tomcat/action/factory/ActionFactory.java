package com.jhamobi.trackiya.server.tomcat.action.factory;

import com.jhamobi.trackiya.server.tomcat.action.Action;
import com.jhamobi.trackiya.server.tomcat.action.ActionPath;
import com.jhamobi.trackiya.server.tomcat.action.impl.LoginAction;
import com.jhamobi.trackiya.server.tomcat.action.impl.ReLoginAction;
import com.jhamobi.trackiya.server.tomcat.action.impl.UpdateVehicleStateAction;
import com.jhamobi.trackiya.server.tomcat.action.impl.UpdatingRunningDataAction;


/**
 * 
 * @author majha
 *
 */
public class ActionFactory {

	public static Action getAction(ActionPath aPath){
		Action action = null;
		switch (aPath) {	
		case UPDATE_VEHICLE_STATE:
			action = new UpdateVehicleStateAction();
			break;
		case UPDATE_RUNNING_DATA:
			action = new UpdatingRunningDataAction();
			break;
		case LOGIN_ACTION:
			action = new LoginAction();
			break;
		case RELOGIN_ACTION:
			action = new ReLoginAction();
			break;
		default:
			break;
		}
		return action;
	}
}
