package com.example.hellomap;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends Activity implements OnMapReadyCallback {
	private Context context;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

	@Override
	public void onMapReady(GoogleMap map) {
		// TODO Auto-generated method stub
		LatLng sabadell = new LatLng(41.536, 2.102);
		
		setupCamera(map);
		
		// You can customize the marker image using images bundled with
        // your app, or dynamically generated bitmaps.
        map.addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(sabadell));
    
	}

	
	// 1- Setup Hello Map 
	private void setupCamera(GoogleMap map) {
		// Declarem la variable sobre la que el mapa s'obrirà
		LatLng sabadell = new LatLng(41.536, 2.102);
		
		// Movem la càmera allà on volem
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sabadell, 13));
	}
	
	private void setupCustomMap(GoogleMap map, LatLng latlang, String title, String snippet) {
		// Personalització del mapa
        map.addMarker(new MarkerOptions()
                .title(title)
                .snippet(snippet)
                .position(latlang));
	}
	
	private void setupCustomMap(GoogleMap map, LatLng[] latlang, String title, String snippet) {
		
	}
	
	
}
