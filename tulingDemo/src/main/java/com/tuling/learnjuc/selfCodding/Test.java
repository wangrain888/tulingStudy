package com.tuling.learnjuc.selfCodding;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test {

    public static void main(String[] args) {
        char c = 'a';
        char b = 'a';
        System.out.println("char size: " + Character.SIZE / 8 + " bytes");
        System.out.println("char memory usage: " + getObjectSize(c) + " bytes");

        String s = "Hello World";
        System.out.println("String size: " + s.length() * 2 + " bytes");
        System.out.println("String memory usage: " + getObjectSize(s) + " bytes");

        System.out.println("aa".getBytes().length);
//        System.out.println('a'.getBytes().length);


    }

    public static long getObjectSize(Object o) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(o);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baos.toByteArray().length;
    }
}
