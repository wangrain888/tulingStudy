package com.tuling.learnjuc.selfCodding;

public class TestInterrupted {


    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {

//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println(1);
//            }
//
//            for (int i = 0; i < 100; i++) {
//                System.out.println(i);
//            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("中断了");
            }

//            Thread.interrupted();

            System.out.println("2222222222222");

        });
//        System.out.println();
        thread.start();

        Thread.sleep(6666);
//
        thread.interrupt();
        Thread.interrupted();

//        System.out.println("线程中断");

    }
}


