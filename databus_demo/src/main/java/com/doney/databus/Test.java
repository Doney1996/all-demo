package com.doney.databus;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        timer.schedule(task,1,1000);
    }
}
