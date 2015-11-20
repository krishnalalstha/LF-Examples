package com.lf.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        bindData();
    }

    /**
     * Initilize the view which are defined in the layout file
     */
    private void init() {
        listview = (ListView) findViewById(R.id.listview);
        listview.setOnItemClickListener(this);
    }


    private void bindData() {
        ArrayAdapter<String> mStringArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Example_title));
        listview.setAdapter(mStringArrayAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String clickItem = (String) parent.getAdapter().getItem(position);
        Toast.makeText(MainActivity.this, "Position click :" + position + " " + clickItem, Toast.LENGTH_SHORT).show();

        switch (position) {
            case 0:
                //go to LinerLayout Example Activoty
                break;
            case 1:
                //go to RelativeLayout Example
                break;
            default:
                break;
        }

    }
}