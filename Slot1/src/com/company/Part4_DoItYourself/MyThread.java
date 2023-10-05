package com.company.Part4_DoItYourself;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(this.getName());
        this.setName("myJavaThread");
        System.out.println(this.getName());

        for (int i = 0; i < 20; i++) {
            if (i%2==0) {
                System.out.println(i);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
