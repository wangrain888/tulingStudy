package com.tuling.learnjuc.selfCodding;

import lombok.SneakyThrows;

public class TestJoin {

    public static void main(String[] args) {
        Wdy wdy1 = new Wdy("1");
        Wdy wdy2 = new Wdy(wdy1, "2");
        Wdy wdy3 = new Wdy(wdy2, "3");

        wdy3.start();
        wdy2.start();
        wdy1.start();
    }

}

class Wdy extends Thread {

    Wdy(String i) {
        this.i = i;
    }

    Wdy(Thread thread, String i) {
        this.thread = thread;
        this.i = i;
    }

    Thread thread;

    String i;

    public Thread getThread() {
        return thread;
    }

    public void setI(String i) {
        this.i = i;
    }

    @SneakyThrows
    @Override
    public void run() {
//        super.run();
        if (thread != null) {
            this.thread.join();
        }
        System.out.println(i);
    }
}



