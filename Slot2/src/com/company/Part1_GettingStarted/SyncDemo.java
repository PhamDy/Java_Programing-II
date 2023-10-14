package com.company.Part1_GettingStarted;

public class SyncDemo {
    public static void main(String[] args) {
        final Counter ct = new Counter();
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                ct.count();
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                ct.count();
            }
        };

        new Thread(t1).start();
        new Thread(t2).start();

    }
}
