package com.interview.jdk.study;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 2021/1/30.
 *
 * @author junpeng li
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("key", "value");
    }
}
