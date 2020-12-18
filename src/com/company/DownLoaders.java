package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class DownLoaders extends Thread {
    private CountDownLatch uplounder;
    private CountDownLatch downlanders;
    private Semaphore semaphore;

    public DownLoaders(String name, CountDownLatch uplounder, CountDownLatch downlanders, Semaphore semaphore) {
        super(name);
        this.uplounder = uplounder;
        this.downlanders = downlanders;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            uplounder.await();
            semaphore.acquire();
            System.out.println(getName() + "nachal zagruzku ");
            sleep(4000);
            System.out.println(getName()+ " zav zagruzku ");
            downlanders.countDown();
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
