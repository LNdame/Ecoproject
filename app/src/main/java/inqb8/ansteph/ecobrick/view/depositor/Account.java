package inqb8.ansteph.ecobrick.view.depositor;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.WriterException;

import java.util.Collection;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;
import inqb8.ansteph.ecobrick.R;
import inqb8.ansteph.ecobrick.model.User;
import inqb8.ansteph.ecobrick.view.collector.Collections;
import inqb8.ansteph.ecobrick.view.collector.RecordCollection;

public class Account extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    AutoCompleteTextView edtFName, edtLName, edtUsername, edtContact;
    TextView txtJoinDate;

    ImageView qrImage;
    Bitmap bitmap;
    QRGEncoder qrgEncoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
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

        qrImage = (ImageView) findViewById(R.id.QR_Image);
        edtFName= (AutoCompleteTextView) findViewById(R.id.txtuserFName);
        edtLName= (AutoCompleteTextView) findViewById(R.id.txtuserLname);
        edtUsername= (AutoCompleteTextView) findViewById(R.id.txtusername);
        edtContact= (AutoCompleteTextView) findViewById(R.id.txtuserContact);

        txtJoinDate = (TextView) findViewById(R.id.txtJoinedDate);

        User user = new User ("John", "Doe", "JDeca","2018/04/02", "0784364734","jdeca-eco-36473" );

        fillFields(user);

    }


    public void fillFields(User user){

        edtFName.setText(user.getFirstname());
        edtLName.setText(user.getLastname());
        edtUsername.setText(user.getUsername());
        edtContact.setText(user.getContact());

        txtJoinDate .setText(user.getJoinDate());


        if(user.getUsercode()!=null)
        {
            generateQR(user.getUsercode());
        }


    }

    public void generateQR(String code)
    {
        code = code.trim();

        if(code.length()>0){

            WindowManager manager=(WindowManager) getSystemService(WINDOW_SERVICE);
            Display display = manager.getDefaultDisplay();

            Point point = new Point();
            display.getSize(point);
            int width = point.x;
            int height = point.y;
            int smallerDimension = width < height ? width : height;
            smallerDimension = smallerDimension * 3 / 4;


            qrgEncoder = new QRGEncoder(code,null, QRGContents.Type.TEXT, smallerDimension);

            try{
                bitmap = qrgEncoder.encodeAsBitmap();
                qrImage.setImageBitmap(bitmap);
            }catch (WriterException e)
            {
                e.printStackTrace();
            }

        }

    }




    public void onDoneClicked(View view){

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
        getMenuInflater().inflate(R.menu.account, menu);
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
            startActivity(new Intent(getApplicationContext(), Depots.class  ));

        } else if (id == R.id.nav_account) {
          //  startActivity(new Intent(getApplicationContext(), Account.class  ));
        } else if (id == R.id.nav_event) {
            startActivity(new Intent(getApplicationContext(), Events.class  ));
        } else if (id == R.id.nav_collector) {
            startActivity(new Intent(getApplicationContext(), Collections.class  ));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
