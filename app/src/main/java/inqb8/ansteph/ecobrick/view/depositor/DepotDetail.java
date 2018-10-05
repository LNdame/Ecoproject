package inqb8.ansteph.ecobrick.view.depositor;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import inqb8.ansteph.ecobrick.R;
import inqb8.ansteph.ecobrick.model.Depot;

public class DepotDetail extends AppCompatActivity implements OnMapReadyCallback {

    Depot mCurrentDepot;

    MapView mMapView;
    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depot_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();


                getDirections(mCurrentDepot.getLatitude(), mCurrentDepot.getLongitude());

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            mCurrentDepot = (Depot) bundle.getSerializable("depot");
            setTitle(mCurrentDepot.getName());
            setupUI(mCurrentDepot);
        }else{
            Toast.makeText(getApplicationContext(), "Oups! No profile found for this establisment!", Toast.LENGTH_LONG).show();
            this.finish();
        }


        try{
            MapsInitializer.initialize(getApplicationContext());
            mMapView = (MapView) findViewById(R.id.map);
            mMapView.onCreate(savedInstanceState);
            mMapView.getMapAsync(this);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    void getDirections(String latitude, String longitude  )
    {
        String address  = "http://maps.google.com/maps?daddr=" +latitude+" , "+longitude;

        Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(address));
        startActivity(intent);
    }





    void setupUI(Depot depot)
    {
        TextView txtname = (TextView) findViewById(R.id.txtdeptName);
        TextView txtAddress = (TextView) findViewById(R.id.txtaddress);
        TextView txtDesc = (TextView) findViewById(R.id.txtdescription);

        TextView txtStartDate = (TextView) findViewById(R.id.txtstardate);
        TextView txtEndDate = (TextView) findViewById(R.id.txtenddate);

      //  mProfilePic = (KenBurnsView) findViewById(R.id.mainPicture);

     //   String imgUrl= Routes.DOMAIN+event.getMain_picture_url();

      /*  Glide.with(getApplicationContext()).load(imgUrl).
                thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(mProfilePic);*/

        txtname.setText(depot.getName());
        txtAddress.setText(depot.getAddress());
        txtDesc.setText(depot.getDescription());

        txtStartDate.setText(depot.getOpenHour());
        txtEndDate.setText(depot.getCloseHour());

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


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        mGoogleMap.getUiSettings().setZoomControlsEnabled(false);
        mGoogleMap.getUiSettings().setZoomGesturesEnabled(true);


        LatLng cpt = new LatLng(Double.parseDouble(mCurrentDepot.getLatitude()),Double.parseDouble(mCurrentDepot.getLongitude()));
        mGoogleMap.addMarker(new MarkerOptions().position(cpt).title("Eco Cape Town"));
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cpt,10.9f));
    }
}
