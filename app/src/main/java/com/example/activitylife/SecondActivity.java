package com.example.activitylife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (savedInstanceState == null) {
            // первый запуск
            logCycle("onCreate() First launch");
        } else {
            logCycle("onCreate() Recreate launch");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        logCycle("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logCycle("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logCycle("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logCycle("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logCycle("onDestroy()");
    }

    private void logCycle(String message) {
        Log.d("SecondActivity", message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}