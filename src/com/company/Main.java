package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch uploader = new CountDownLatch(1);
        CountDownLatch downloader = new CountDownLatch(10);
        Uplooader uplooader1 = new Uplooader("",uploader);
        Semaphore semaphore = new Semaphore(4,true);
        uplooader1.start();
        for (int i = 1; i < 11; i++) {
            new DownLoaders("Chel" + i, uploader, downloader, semaphore).start();
        }

        try {
            downloader.await();
            System.out.println("fail udalilsya iz servera");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
