package com.example.hellomap;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;


public class MainActivity extends Activity implements OnMapReadyCallback {
	private Context context;
	private LatLng[] TEST_POSITIONS;
	// This value define where the map is going to center its focus
	private LatLng START_COORDINATES = new LatLng(41.5421871,2.1085581);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Full screen
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
        setContentView(R.layout.activity_main);
        
        // For testing we prefer block the orientation to portrait.
        setRequestedOrientation(1);
        
               
        
        // Typical findViewByID. In this case, findFragmentByID
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

	@Override
	public void onMapReady(GoogleMap map) {
		// Set the camera Map.				
		setupMap(map, this.START_COORDINATES, 16, true);
		
		// Read all markers from API --> method that will have to return an array of LatLng[] (positions)
		// Instead and for now, we just give him some points to print.
		TEST_POSITIONS = new LatLng[] {
				new LatLng(41.5412436, 2.1068093), new LatLng(41.5427653,2.1090946), 
				new LatLng(41.5414523,2.1097008), new LatLng(41.5407577,2.1093628), 
				new LatLng(41.5407176,2.1077159), new LatLng(41.5409223,2.1069005),
				new LatLng(41.5412917,2.1063748), new LatLng(41.5419944,2.1062729), 
				new LatLng(41.5428898,2.1071312), new LatLng(41.5435201,2.1083114)
		};
		
		// Load all markers
		addNewMultipleMarkers(map, TEST_POSITIONS, null, null);
		
    
	}


	private void setupMap(GoogleMap map, LatLng initialFocus, int zoom, boolean myLocation) {		
		// Movem la càmera allà on volem
        map.setMyLocationEnabled(myLocation);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(initialFocus, zoom));
	}
	
	private void addNewMarkerOn(GoogleMap map, LatLng position, String title, String snippet) {
        map.addMarker(new MarkerOptions()
                .title(title)
                .snippet(snippet)
                // Display the custom marker:
//              	.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
        // Anchors the marker on the bottom left:
                .anchor(0.0f, 1.0f) 
                // Set the given position
                .position(position));
	}
	
	private void addNewMultipleMarkers(GoogleMap map, LatLng[] positions, String title, String snippet) {
		for	(int i = 0; i < positions.length; i++) {
			addNewMarkerOn(map, positions[i], title, snippet);
		}
	}
	
	private LatLng[] getAllPositionsFromAPI() {
		LatLng[] positions = null;
		// TODO: Implements the method
		
		
		return positions;
	}
}
