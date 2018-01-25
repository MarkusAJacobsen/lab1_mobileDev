package com.example.markusja.lab1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    public static final String PREFS_NAME = "PrefsFile";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Restore preferences
        preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String selected = preferences.getString("Selected", "list 1");

        addItemsSpinner(selected);

        Button btn = (Button) findViewById(R.id.activity2);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Selected", spinner1.getSelectedItem().toString());
                editor.apply();

                EditText editText = (EditText) findViewById(R.id.activity1text);
                String text = editText.getText().toString();

                Intent intent = new Intent(v.getContext(), Activity2.class);
                intent.putExtra("textActivity1", text);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void addItemsSpinner(String selected) {
        spinner1 = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("list 1");
        list.add("list 2");
        list.add("list 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);

        switch (selected) {
            case "list 1":
                spinner1.setSelection(0);
                break;
            case "list 2":
                spinner1.setSelection(1);
                break;
            default:
                spinner1.setSelection(2);
                break;
        }
    }
}
