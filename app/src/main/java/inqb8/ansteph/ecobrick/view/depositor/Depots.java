package inqb8.ansteph.ecobrick.view.depositor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import inqb8.ansteph.ecobrick.R;
import inqb8.ansteph.ecobrick.adapter.DepotRecyclerAdapter;
import inqb8.ansteph.ecobrick.model.Depot;
import inqb8.ansteph.ecobrick.view.collector.Collections;
import inqb8.ansteph.ecobrick.view.collector.RecordCollection;

public class Depots extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, GoogleMap.OnCameraChangeListener  {

    private  static String TAG = Depots.class.getSimpleName();


    MapView mMapView;

    Marker[] mPubMarker ;

    private GoogleMap mGoogleMap;
    RecyclerView mDepotRecyclerView;
    ArrayList<Depot> mDepotList;
    DepotRecyclerAdapter mDepotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depots);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        try{
            MapsInitializer.initialize(getApplicationContext());
            mMapView = (MapView) findViewById(R.id.map);
            mMapView.onCreate(savedInstanceState);
            mMapView.getMapAsync(this);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mDepotRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mDepotList = setupList();// new ArrayList<>();

        mDepotRecyclerView.setLayoutManager(mLayoutManager);
        mDepotAdapter= new DepotRecyclerAdapter(this, mDepotList);

        mDepotRecyclerView.setAdapter(mDepotAdapter);



    }


    ArrayList<Depot> setupList()
    {
        ArrayList<Depot>  promos = new ArrayList<>();

        promos.add(new Depot (1,"Bergvliet Depot" ,"14-2 De Rust Ave Bergvliet, Cape Town, 7945","Jane Doe", "0376465537" ,"-34.046932","18.452201","active", "06:00:00", 	"21:00:00", "Depot Bottle"));

        promos.add(new Depot (2,"Sherwood Depot" ,"1-57 Sherwood Cl Parklands, Cape Town, 7441","Jane Doe", "0376465537" ,"-33.812459","18.503699","active", "06:00:00", 	"21:00:00", "Depot Bottle"));

        promos.add(new Depot (3,"Plumstead Depot" ,"Plumstead Cape Town, 7800","Jane Doe", "0376465537" ,"-34.019439","18.475828","active", "06:00:00", 	"21:00:00", "Depot Bottle"));

        promos.add(new Depot (4,"Fairways Depot" ,"106-80 2nd Ave Fairways, Cape Town, 7800","Jane Doe", "0376465537" ,"-34.019439","18.495586","active", "06:00:00", 	"21:00:00", "Depot Bottle"));

        promos.add(new Depot (5,"Lotus River Depot" ,"22-6 Waterford Rd Lotus River, Cape Town, 7805","Jane Doe", "0376465537" ,"-34.035706","18.515491","active", "06:00:00", 	"21:00:00", "Depot Bottle"));

        promos.add(new Depot (6,"Heideveld Depot" ,"44-6 Postern Rd Heideveld, Cape Town, 7764","Jane Doe", "0376465537" ,"-33.964849","18.554863","active", "06:00:00", 	"21:00:00", "Depot Bottle"));

        promos.add(new Depot (7,"Bothasig Depot" ,"2-34 Van Riebeeck St Bothasig, Cape Town, 7441","Jane Doe", "0376465537" ,"-33.865192","18.543959","active", "06:00:00", 	"21:00:00", "Depot Bottle"));

        // String duration, String task_date, String start, String end, String project, String description, String realduration, String task_break) {
        return  promos;
    }







    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.depots, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_depot) {
            // Handle the camera action
          //  startActivity(new Intent(getApplicationContext(), Depots.class  ));

        } else if (id == R.id.nav_account) {
            startActivity(new Intent(getApplicationContext(), Account.class  ));
        } else if (id == R.id.nav_event) {
            startActivity(new Intent(getApplicationContext(), Events.class  ));
        } else if (id == R.id.nav_collector) {
            startActivity(new Intent(getApplicationContext(), Collections.class  ));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

        //initMarker(mDepotList);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.getUiSettings().setZoomControlsEnabled(false);
        mGoogleMap.getUiSettings().setZoomGesturesEnabled(true);


        LatLng cpt = new LatLng(-33.926172, 18.424690);
        mGoogleMap.addMarker(new MarkerOptions().position(cpt).title("Eco Cape Town"));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cpt,10.9f));
     //  LatLng pe = new LatLng(-33.926172, 18.424690);
     //  mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pe,10.9f));
        initMarker(mDepotList);
    }


    private void initMarker(ArrayList<Depot> depots)
    {
        mGoogleMap.clear();
        mPubMarker = new Marker[depots.size()];

        for(int i = 0; i<depots.size();i++)
        {
            Depot item = depots.get(i);

            if(i==0){
                mPubMarker[i] = mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(item.getLatitude()),Double.parseDouble(item.getLongitude())))
                        .title(item.getName())
                        .snippet("Go have fun").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_map_pin_select)));
            }else{

                mPubMarker[i] = mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(Double.parseDouble(item.getLatitude()),Double.parseDouble(item.getLongitude())))
                        .title(item.getName())
                        .snippet("Go have fun").icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_map_pin_reg)));}
        }
    }






    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();

    }


}
