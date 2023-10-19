package com.jhamobi.trackiya.client;

import com.google.gwt.maps.client.InfoWindow;
import com.google.gwt.maps.client.InfoWindowContent;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.control.LargeMapControl;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.maps.client.overlay.Marker;
import com.google.gwt.user.client.Timer;
public class MapWebPage {
	private MapWidget map;
	public MapWebPage() {

	}

	public MapWidget InitMapWebPage() {
//		LatLng somewhereInTexas = LatLng.newInstance(30.000, -97.000);
//		 
//        map = new MapWidget(somewhereInTexas, 2);
//        map.setSize("500px", "500px");
//        map.addControl(new LargeMapControl());
// 
//        final Marker marker = new Marker(somewhereInTexas);
//        map.addOverlay(marker);
// 
//        final InfoWindow infoWin = map.getInfoWindow();
//        infoWin.open(map.getCenter(), new InfoWindowContent("Deep in Texas..."));
// 
//        Timer t = new Timer()
//        {
//            public void run()
//            {
//                LatLng newAddress = LatLng.newInstance(18.000, 10.000);
// 
//                infoWin.close();
//                marker.setVisible(false);
//                marker.setLatLng(newAddress);
//                marker.setVisible(true);
//                map.getInfoWindow().open(newAddress, new InfoWindowContent("Somewhere in Africa..."));
//                map.panTo(newAddress);
//            }
//        };
// 
//        t.schedule(6000);
        
        return map;
 
//		 Window.Location.assign(GWT.getHostPageBaseURL() + "war/map.html");
//		 
//		 Frame frame = new Frame();
//		 frame.setUrl(GWT.getHostPageBaseURL() + "war/map.html");
//
//		return frame;

	}

	// public static native void InitMapWebPage() /*-{
	// var map;
	// function initMap() {
	// map = new google.maps.Map(document.getElementById('map'), {
	// center : {
	// lat : -34.397,
	// lng : 150.644
	// },
	// zoom : 8
	// });
	// }
	// }-*/;
}
