package com.spring.boot.study.thrift.service.impl;

import com.spring.boot.study.common.result.InvokeResult;
import com.spring.boot.study.thrift.client.DataService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

@Service
public class DataCoreService implements DataService.Iface {
    @Override
    public InvokeResult DataCore(String value) throws TException {
        long start = System.currentTimeMillis();
        InvokeResult result = new InvokeResult();
        result.setData("Hello World!");
        //尽情发挥
        //尽情发挥
        //尽情发挥
        long end = System.currentTimeMillis();
        System.out.println("spend time:" + (end - start));
        return result;
    }
}
