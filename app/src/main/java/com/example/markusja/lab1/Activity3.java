package com.example.markusja.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by markusja on 1/22/18.
 */

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);

        Button btn = (Button) findViewById(R.id.backToActivity2Button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                EditText editText = (EditText) findViewById(R.id.editText3);
                String text = editText.getText().toString();

                Intent intent = new Intent(v.getContext(), Activity2.class);
                intent.putExtra("editText3", text);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed(){

        startActivity(new Intent(Activity3.this, Activity2.class));
    }
}
