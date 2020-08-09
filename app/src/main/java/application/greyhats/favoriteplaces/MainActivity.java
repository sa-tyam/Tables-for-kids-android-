package application.greyhats.favoriteplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    static ArrayList<String> places = new ArrayList<String>();
    static ArrayList<LatLng> latLngs = new ArrayList<LatLng>();
    static ArrayAdapter mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.listView);

        mArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, places);
        mListView.setAdapter(mArrayAdapter);

        places.add("Add a new place!");
        latLngs.add(new LatLng(0,0));

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(getApplicationContext(), MapsActivity.class);
                mIntent.putExtra("position", position);
                startActivity(mIntent);
            }
        });
    }
}