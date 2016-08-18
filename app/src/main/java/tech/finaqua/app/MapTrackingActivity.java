package tech.finaqua.app;

import android.graphics.Color;
import android.os.Bundle;
//import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Random;

public class MapTrackingActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_tracking);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng Kuwait = new LatLng(29.316428, 48.079656);
        mMap.addMarker(new MarkerOptions().position(Kuwait).title("Marker in Kuwait"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Kuwait));

        Random randomGenerator = new Random();
        /*LatLng fir = new LatLng(29.316428, 47.079656);
        for (int i=0;i<5;i++) {
            int randomInt1 = randomGenerator.nextInt(10);
            int randomInt2 = randomGenerator.nextInt(10);
            LatLng sec = new LatLng(29.316428 + randomInt1, 47.079656 + randomInt2);

            mMap.addMarker(new MarkerOptions().position(sec).title("Marker in two"));
            Polyline line = mMap.addPolyline(new PolylineOptions()
                    .add(fir,sec)
                    .width(5)
                    .color(Color.RED));
            fir= sec;
        }*/



        LatLng loc01 = new LatLng(29.229477, 48.197127);
        LatLng loc02 = new LatLng(29.493434, 48.418809);
        LatLng loc03 = new LatLng(29.321169, 48.589493);
        LatLng loc04 = new LatLng(29.052217, 48.751852);
        LatLng loc05 = new LatLng(29.229477, 48.197127);
        Polyline line = mMap.addPolyline(new PolylineOptions()
                .add(loc01,loc02,loc03,loc04,loc05)
                .width(5)
                .color(Color.RED));
    }
}
