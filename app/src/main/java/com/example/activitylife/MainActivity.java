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

    private TextView counterText;

    private Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.counter_text);

        if (savedInstanceState == null) {
            // первый запуск

            counter = new Counter();

            logCycle("onCreate() First launch");
        } else {
            logCycle("onCreate() Recreate launch");

            // можно восстановить тут (тут понятнее, что не первый запуск), а можно в onRestoreInstanceState()
            counter = savedInstanceState.getParcelable(ARG_COUNT);
            counterText.setText(getString(R.string.count_value, counter.getValue()));
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
        counterText.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_increase_count).setOnClickListener(v -> {
            counter.increase();
            counterText.setText(getString(R.string.count_value, counter.getValue()));
        });


    }

/*
    // вызывается только если есть что восстанавливать
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getParcelable(ARG_COUNT); // восстанавливаем сохранённое значение
        counterText.setText(getString(R.string.count_value, counter.getValue())); // выводим в поле на экране
    }
*/

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
        outState.putParcelable(ARG_COUNT, counter);
        super.onSaveInstanceState(outState);
    }

    private void logCycle(String message) {
        Log.d("MainActivity", message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}