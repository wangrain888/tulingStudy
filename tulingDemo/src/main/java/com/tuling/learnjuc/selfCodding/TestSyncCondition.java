package com.tuling.learnjuc.selfCodding;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestSyncCondition {

    public static void main(String[] args) throws InterruptedException {
        int maxSize = 10;

        ReentrantLock reentrantLock = new ReentrantLock();

        //队列
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue(new ArrayList());
//        concurrentLinkedQueue.add("1");
//        concurrentLinkedQueue.poll();

        Queue queue = new Queue(maxSize, reentrantLock, concurrentLinkedQueue);

        new Producer(queue).start();

        Thread.sleep(5000);

        new Consumer(queue).start();
    }
}


class Queue {

    int maxSize;

    ReentrantLock reentrantLock;

    Condition proCondition = null;
    Condition consuCondition = null;
    ConcurrentLinkedQueue concurrentLinkedQueue;

    public Queue(int maxSize, ReentrantLock reentrantLock, ConcurrentLinkedQueue concurrentLinkedQueue) {
        this.maxSize = maxSize;
        this.reentrantLock = reentrantLock;
        this.concurrentLinkedQueue = concurrentLinkedQueue;
        proCondition = reentrantLock.newCondition();
        consuCondition = reentrantLock.newCondition();
    }

    /**
     * 拉取
     *
     * @param
     */
    public void poll() {
        reentrantLock.lock();
        try {
            if (this.concurrentLinkedQueue.size() <= maxSize && this.concurrentLinkedQueue.size() > 0) {
                System.out.println("生产者唤醒====");
                proCondition.signalAll();
            }
            if (this.concurrentLinkedQueue.size() == 0) {
                System.out.println("队列空了，消费暂停");
                consuCondition.await();
            }
            Object object = concurrentLinkedQueue.poll();
            System.out.println(object.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    /**
     * 制造
     *
     * @param
     */
    public void add() throws InterruptedException {
        reentrantLock.lock();

        try {
            if (this.concurrentLinkedQueue.size() >= maxSize) {
                System.out.println("生产者等待====");
                proCondition.await();
            }

            concurrentLinkedQueue.add(new Random(1000).nextInt());

            if (this.concurrentLinkedQueue.size() > 0) {
                System.out.println("消费者可以开始消费了");
                consuCondition.signalAll();
            }


//            if (concurrentLinkedQueue.size() > 0) {
////                System.out.println("队列有值了");
//                consuCondition.signalAll();
//            }

//            Thread.sleep(500);

        } finally {
            reentrantLock.unlock();
        }


    }
}


/**
 * 生产者
 */
class Producer extends Thread {

    Queue queue;

    Producer(Queue queue) {
        this.queue = queue;
    }


    @SneakyThrows
    @Override
    public void run() {

        while (true) {
            this.queue.add();
        }

    }
}

/**
 * 消费者
 */
class Consumer extends Thread {

    Queue queue;

    Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            this.queue.poll();
        }

    }
}


