package com.company.Part4_DoItYourself;

public class mthreads extends Thread{
    private String name;
    private int finish;

    public mthreads(String name, int finish) {
        this.name = name;
        this.finish = finish;
    }

    @Override
    public void run() {
        for (int i = finish; i > 0 ; i--) {
            System.out.println(name + " : " + i);
            if (i==1) {
                System.out.println(name + " exiting.");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        mthreads m1 = new mthreads("First", 5);
        mthreads m2 = new mthreads("Second", 5);
        mthreads m3 = new mthreads("Third", 5);
        m1.start();
        m2.start();
        m3.start();
        try {
            m1.join();
            m2.join();
            m3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Main thread exiting");
    }

}
