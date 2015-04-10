package data.android.unisa.com.iset;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.thabang.iset.dto.EventsDTO;
import com.thabang.iset.providers.contentProviderUtil.EventsContentProvidersUtil;


public class AddingEvents extends ActionBarActivity {
    Button btneventsList;
    Button btnSubmit;
    TextView txtEventName;
    TextView txtLocation;
    TextView txtDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_events);

        txtEventName = (TextView) findViewById(R.id.txtEventName);
        txtLocation = (TextView) findViewById(R.id.txtLocation);
        txtDate = (TextView) findViewById(R.id.txtDate);
        btnSubmit =  (Button) findViewById(R.id.btnSubmit);

        btneventsList = (Button) findViewById(R.id.btnSubmit);
        btneventsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListEvents.class);
                Bundle b = new Bundle();
                b.putString("name",txtEventName.getText().toString());
                b.putString("location",txtLocation.getText().toString());
                b.putString("date",txtDate.getText().toString());
                intent.putExtra("EventBundle",b);

               // EventsDTO eventsDTO = new EventsDTO(null, txtEventName,txtLocation,txtDate,1,1,null);
                //add this to CP
               // EventsContentProvidersUtil.addevent(getContentResolver(), eventsDTO);
                startActivity(intent);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adding_events, menu);
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
