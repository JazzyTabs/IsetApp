package data.android.unisa.com.iset;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ListEvents extends ActionBarActivity {
    TextView name;
    TextView date;
    TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_events);

        name = (TextView) findViewById(R.id.txtEventName);
        date = (TextView) findViewById(R.id.txtDate);
        location = (TextView) findViewById(R.id.txtLocation);

        Bundle b = this.getIntent().getBundleExtra("EventBundle");

        String name = b.getString("name");
        String date = b.getString("date");
        String location = b.getString("location");
        //Still Setting
      //  name.setText();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_events, menu);
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
