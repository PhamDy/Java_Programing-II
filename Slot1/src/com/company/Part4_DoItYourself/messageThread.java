package com.company.Part4_DoItYourself;

public class messageThread extends Thread{
    private String message;
    private int duration;
    private int priority;

    public messageThread(String message, int duration, int priority) {
        this.message = message;
        this.duration = duration;
        this.priority = priority;
    }
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(message);
                Thread.sleep(duration);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        messageThread m1 = new messageThread("multithreading", 1000, Thread.MAX_PRIORITY);
        messageThread m2 = new messageThread("Multitasking", 2000, Thread.NORM_PRIORITY);
        m1.start();
        m2.start();
    }
}
