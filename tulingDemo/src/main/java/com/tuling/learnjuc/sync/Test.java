package com.tuling.learnjuc.sync;

public class Test {

    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        System.out.println(++i == 2);
        System.out.println(j++ == 2);

        System.out.println(i);
        System.out.println(j);

    }
}
