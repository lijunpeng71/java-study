package com.interview.test.study;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created on 2021/1/27.
 *
 * @author junpeng li
 */
public abstract class AbsTest {


    public static void main(String[] args) {

        ConcurrentHashMap map = new ConcurrentHashMap(1);
        HashSet hashSet = new HashSet();
        map.put("key1", 1);
    }
}
