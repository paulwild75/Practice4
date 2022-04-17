package com.shiryaev.pavel.bsbo_08_19.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        tv = findViewById(R.id.textView);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                double days, les;
                days = 5;
                les = 15;
                result = les / days;
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread thread = new Thread(runnable);
                thread.start();
                tv.setText(result + " - количество пар");
            }
        });
    }
}