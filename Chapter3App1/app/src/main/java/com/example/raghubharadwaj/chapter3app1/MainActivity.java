package com.example.raghubharadwaj.chapter3app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayAdapter<String> gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        String[] someColors = new String[]{"Red","YelloW","Blue","Green","Orange"};
        ArrayList<String> stringArray = new ArrayList<>(5);
        stringArray.addAll(Arrays.asList(someColors));
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,stringArray);
        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_LONG).show();
            }
        });

        gridViewAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringArray);
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            }
        });



    }
}
