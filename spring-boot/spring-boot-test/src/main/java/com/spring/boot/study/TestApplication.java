package com.spring.boot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        LinkedHashSet linkedHashSet=new LinkedHashSet();
        linkedHashSet.add(1);
        LinkedList linkedList;
        TreeSet treeSet;
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
    }
}
