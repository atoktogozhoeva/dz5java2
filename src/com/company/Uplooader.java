package com.company;

import java.util.concurrent.CountDownLatch;

public class Uplooader extends Thread {
    private CountDownLatch uplouder;

    public Uplooader(String name, CountDownLatch uplouder) {
        super(name);
        this.uplouder = uplouder;
    }

    @Override
    public void run() {
        try {
            System.out.println("zagruzka nach");
            sleep(1200);
            System.out.println("zagruzka zav");
            uplouder.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
