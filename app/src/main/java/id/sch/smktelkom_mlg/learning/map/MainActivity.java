package id.sch.smktelkom_mlg.learning.map;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition TRENGGALEK = CameraPosition.builder()
            .target(new LatLng(-8.088482, 111.664209))
            .zoom(10).bearing(0)
            .tilt(45).build();

    GoogleMap m_map;
    boolean mapReady = false;

    MarkerOptions Tugu;
    MarkerOptions Karangan;
    MarkerOptions Dongko;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tugu = new MarkerOptions()
                .position(new LatLng(-8.045474, 111.655577))
                .title("Tugu");


        Karangan = new MarkerOptions()
                .position(new LatLng(-8.054786, 111.682053))
                .title("Karangan");


        Dongko = new MarkerOptions()
                .position(new LatLng(-8.157587, 111.579340))
                .title("Dongko");


        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapReady = true;
        m_map = googleMap;
        m_map.addMarker(Tugu);
        m_map.addMarker(Karangan);
        m_map.addMarker(Dongko);
        flyTo(TRENGGALEK);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
