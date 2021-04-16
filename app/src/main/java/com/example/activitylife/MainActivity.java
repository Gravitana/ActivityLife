package com.example.activitylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String ARG_COUNT = "ARG_COUNT";

    private TextView counter;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.counter);

        if (savedInstanceState == null) {
            // первый запуск
            logCycle("onCreate() First launch");
        } else {
            logCycle("onCreate() Recreate launch");
/*
            // можно восстановить тут, а можно в onRestoreInstanceState()
            count = savedInstanceState.getInt(ARG_COUNT);
            counter.setText(getString(R.string.count_value, count));
*/
        }

/*      // свернули в лямбду
        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
*/
        counter.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_increase_count).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                counter.setText(getString(R.string.count_value, count));
            }
        });


    }

    // вызывается только если есть что восстанавливать
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count = savedInstanceState.getInt(ARG_COUNT); // восстанавливаем сохранённое значение
        counter.setText(getString(R.string.count_value, count)); // выводим в поле на экране
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(ARG_COUNT, count);
        super.onSaveInstanceState(outState);
    }

    private void logCycle(String message) {
        Log.d("MainActivity", message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}