package com.example.activitylife;

import java.io.Serializable;

public class Counter implements Serializable {
    private int value;

    public Counter() {
    }

    public int getValue() {
        return value;
    }

    public void increase() {
        value++;
    }
}
