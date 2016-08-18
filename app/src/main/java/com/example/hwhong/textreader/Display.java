package com.example.hwhong.textreader;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by hwhong on 8/18/16.
 */
public class Display extends AppCompatActivity {

    private ArrayList<String> string;
    private ArrayList<Integer> intArray;
    private ArrayList<String> finalArray;

    private ListView listView;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        listView = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        string = intent.getStringArrayListExtra("string");
        intArray = intent.getIntegerArrayListExtra("int");
        finalArray = new ArrayList<>();

        for(int i = 0; i < string.size(); i++) {
            finalArray.add("There are " + intArray.get(i) + string.get(i) +  " in the Text.");
        }

        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, finalArray);
        listView.setAdapter(adapter);
    }
}
