package com.lf.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        Intent mIntent;
        switch (position) {
            case 0:
                //go to LinerLayout Example Activoty
                break;
            case 1:
                //go to RelativeLayout Example
                break;
            case 14 :
              mIntent  =new Intent(MainActivity.this,WebServiceVolleyExample.class);
                startActivity(mIntent);
                break;
            default:

                break;
        }

    }
}
