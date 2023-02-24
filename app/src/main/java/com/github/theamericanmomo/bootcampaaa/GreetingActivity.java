package com.github.theamericanmomo.bootcampaaa;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        Bundle b = getIntent().getExtras();
        String value = "Empty";
        if (b != null) {
            value = b.getString("key");
        }

        TextView myTextView = findViewById(R.id.greetingMessage);

        myTextView.setText(value);
    }
}