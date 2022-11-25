package com.jiyongfei.java1;

class Window implements Runnable {
    private int ticket = 100;
//    Object obj = new Object();


    @Override
    public void run() {
        while (true) {
            synchronized (this) {//要求：多个线程必须要共用同一把锁。
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }

        }
    }
}

public class WindowTest {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("1111");
        t2.setName("2222");
        t3.setName("3333");

        t1.start();
        t2.start();
        t3.start();
    }
}
