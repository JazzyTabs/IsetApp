package data.android.unisa.com.iset;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.thabang.iset.dto.EventsDTO;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<EventsDTO> myEvents = new ArrayList<EventsDTO>();
    Button btnLogIn;
    Button btnSignUp;
    Button btnMap;
    gpsActivity gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogIn = (Button) findViewById(R.id.signup1);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
            }
        });
        btnSignUp = (Button) findViewById(R.id.login1);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LogIn.class);
                startActivity(intent);
            }
        });

        btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gps = new gpsActivity(MainActivity.this);

                if(gps.canGetLocation()){
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();

                    Toast.makeText(getApplicationContext(),"You location is -\nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
                }else{
                    gps.showSettingsAlert();
                }

//                Intent intent = new Intent(getApplicationContext(),gpsActivity.class);
//                startActivity(intent);
            }
        });

    }

//    private void populateEventList() {
//        myEvents.add(new EventsDTO(1,"Lusaka","Mamelodi",19,1,R.drawable.i_setimage));
//        myEvents.add(new EventsDTO(1,"Lusaka","Mamelodi",14,1,R.drawable.isetthabang));
//        myEvents.add(new EventsDTO(1,"Lusaka","Mamelodi",35,1,R.drawable.i_setimage));
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}
