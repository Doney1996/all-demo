package com.doney.advanced.base;



import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DemoTest {

    private static final Map<String, Map<String, String>> MESSAGE_CACHE = new ConcurrentHashMap<>(8);

    public static void main(String[] args) {

        String key1 ="1";
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("CN","中文");

        String key2 ="2";
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("CN","中文");

        String key3 ="3";
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("CN","中文");

        String key4 ="4";
        HashMap<String, String> map4 = new HashMap<>();
        map4.put("CN","中文");

        MESSAGE_CACHE.computeIfAbsent(key1,k->new HashMap<>()).putAll(map1);
        MESSAGE_CACHE.computeIfAbsent(key2,k->new HashMap<>()).putAll(map2);
        MESSAGE_CACHE.computeIfAbsent(key3,k->new HashMap<>()).putAll(map3);
        MESSAGE_CACHE.computeIfAbsent(key4,k->new HashMap<>()).putAll(map4);



        System.out.println("初始化 完成");
        System.out.println(MESSAGE_CACHE.toString());



        System.out.println("更新");
        HashMap<String, String> updateMap = new HashMap<>();
        updateMap.put("CN","中文 更新");
        MESSAGE_CACHE.computeIfAbsent(key1,k->new HashMap<>()).putAll(updateMap);
        System.out.println(MESSAGE_CACHE.toString());

        System.out.println("删除 1 2 3 ");

        //老的有 新的没有

        //新的
        Map<String, Map<String, String>> NEW_MESSAGE_CACHE = new HashMap<>(8);
        NEW_MESSAGE_CACHE.put(key4,map4);

        MESSAGE_CACHE.keySet().forEach(oldKey->{
            //新的cache里面没有包含旧的值，说明被删除
            if (!NEW_MESSAGE_CACHE.containsKey(oldKey)) {
                //删除旧key
                MESSAGE_CACHE.remove(oldKey);
            }
        });
        System.out.println(MESSAGE_CACHE.toString());

    }
}