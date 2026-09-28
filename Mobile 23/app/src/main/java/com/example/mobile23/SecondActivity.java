package com.example.mobile23;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView textHello;
    private String name;
    private String KEY_NAME = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textHello = (TextView) findViewById(R.id.textHello);

        Bundle extras = getIntent().getExtras();
        name = extras.getString(KEY_NAME);
        textHello.setText("Hello, " + name + "!");
    }
}
