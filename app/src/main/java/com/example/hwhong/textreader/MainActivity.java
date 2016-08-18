package com.example.hwhong.textreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;

    private ArrayList<String> stringArray;
    private ArrayList<Integer> intArray;
    private ArrayList<String> condensed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringArray = new ArrayList<>();
        intArray = new ArrayList<>();
        condensed = new ArrayList<>();

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();

                Scanner scan = new Scanner(text);

                while (scan.hasNext()) {
                    stringArray.add(scan.next());
                }

                for (int i = 0; i < stringArray.size(); i++) {

                    String string = stringArray.get(i);
                    int count = 0;

                    for (int x = 0; x < stringArray.size(); x++) {
                        if (stringArray.get(x).equals(string)) {
                            count++;
                        }
                    }

                    if (!condensed.contains(string)) {
                        condensed.add(string);
                        intArray.add(count);
                    }
                }

                Intent intent = new Intent(getApplicationContext(), Display.class);
                intent.putStringArrayListExtra("string", condensed);
                intent.putIntegerArrayListExtra("int", intArray);

                startActivity(intent);
            }
        });
    }
}
