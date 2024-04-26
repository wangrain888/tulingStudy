package com.tuling.learnjuc.selfCodding;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {

        List<Map<String, Object>> list = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("age", i);
            list.add(map);
        }

        for (Map<String, Object> map : list) {
            new Thread(() -> {
                map.put("name", "11111");
                map.put("ssss", "ssss");
                map.remove("age");
            }).start();
        }

//        list.add(map);
//        list.add(map1);
//        list.add(map2);
//
//        System.out.println(list.hashCode());
//        System.out.println(list.hashCode());
//
//        System.out.println(list.toString());
//
//        List<Map<String,Object>> list1 = list.stream().sorted(Comparator.comparing(res -> res.get("name").toString())).collect(Collectors.toList());
//
//        System.out.println(list.toString());
//        System.out.println(list1.toString());

    }


}
