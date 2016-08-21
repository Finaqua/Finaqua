package tech.finaqua.app.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import tech.finaqua.app.R;

public class MappingFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View map_view = inflater.inflate(R.layout.fragment_mapping, container, false);
        MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return map_view;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //Starting position of the map
        LatLng startingPos = new LatLng(29.27, 48.30);
        //Update the map
        mMap.moveCamera(CameraUpdateFactory.newLatLng(startingPos));
        // Add a marker and move the camera
        LatLng loc01 = new LatLng(29.360141, 47.873036);
        LatLng loc02 = new LatLng(29.416712, 47.789428);
        LatLng loc03 = new LatLng(29.595748, 48.169026);
        LatLng loc04 = new LatLng(28.640166, 48.448991);
        LatLng loc05 = new LatLng(28.994884, 48.511436);
        LatLng loc06 = new LatLng(29.229477, 48.197127);
        LatLng loc07 = new LatLng(29.493434, 48.418809);
        LatLng loc08 = new LatLng(29.321169, 48.589493);
        LatLng loc09 = new LatLng(29.052217, 48.751852);
        LatLng loc10 = new LatLng(29.726388, 48.450641);
        mMap.addMarker(new MarkerOptions().position(loc01).title("Fish Spot 01"));
        mMap.addMarker(new MarkerOptions().position(loc02).title("Fish Spot 02"));
        mMap.addMarker(new MarkerOptions().position(loc03).title("Fish Spot 03"));
        mMap.addMarker(new MarkerOptions().position(loc04).title("Fish Spot 04"));
        mMap.addMarker(new MarkerOptions().position(loc05).title("Fish Spot 05"));
        mMap.addMarker(new MarkerOptions().position(loc06).title("Fish Spot 06"));
        mMap.addMarker(new MarkerOptions().position(loc07).title("Fish Spot 07"));
        mMap.addMarker(new MarkerOptions().position(loc08).title("Fish Spot 08"));
        mMap.addMarker(new MarkerOptions().position(loc09).title("Fish Spot 09"));
        mMap.addMarker(new MarkerOptions().position(loc10).title("Fish Spot 10"));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(9));
    }
}