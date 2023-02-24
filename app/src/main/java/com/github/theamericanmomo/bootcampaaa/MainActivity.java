package com.github.theamericanmomo.bootcampaaa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButton = findViewById(R.id.button);
        EditText mEdit = findViewById(R.id.TextPersonName);

        mButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, GreetingActivity.class);
                        Bundle b = new Bundle();
                        b.putString("key", mEdit.getText().toString());
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();
                    }
                });
    }
}