package com.study.interview.jdk.hashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 2021/2/21.
 *
 * @author Administrator
 */
public class HashMapDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("zhangshan", 30);
        concurrentHashMap.put("lishi", 34);
        concurrentHashMap.get("zhangshan");
    }
}
