package com.example.markusja.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

/**
 * Created by markusja on 1/22/18.
 */

public class Activity2 extends AppCompatActivity{
    EditText T1;
    EditText T2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        T1 = (EditText) findViewById(R.id.noneditText);
        T2 = (EditText) findViewById(R.id.noneditText2);

        Bundle intents = getIntent().getExtras();
        String existsTextActivity1 = null;
        String existsTextActivity3 = null;

        if(intents != null) {
            existsTextActivity1 = intents.getString("textActivity1");
            existsTextActivity3 = intents.getString("editText3");
        }

        if(!empty(existsTextActivity1)){
            T1.setText(String.format("Hello %s", getIntent().getStringExtra("textActivity1")));
        }
        if(!empty(existsTextActivity3)){
            T2.setText(String.format("From A3: %s", getIntent().getStringExtra("editText3")));
        }

        Button btn = (Button) findViewById(R.id.activity3Button);

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, Activity3.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Activity2.this, MainActivity.class));
    }

    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}
