package inqb8.ansteph.ecobrick;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import inqb8.ansteph.ecobrick.view.depositor.Account;
import inqb8.ansteph.ecobrick.view.depositor.Depots;
import inqb8.ansteph.ecobrick.view.registration.Login;
import inqb8.ansteph.ecobrick.view.registration.MapsActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(4000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    /**
                     * Call this function whenever you want to check user login
                     * This will redirect user to Login is he is not
                     * logged in
                     * */
                    //  sessionManager.checkReg();
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);



                }
            }
        };
        timerThread.start();
    }
}
