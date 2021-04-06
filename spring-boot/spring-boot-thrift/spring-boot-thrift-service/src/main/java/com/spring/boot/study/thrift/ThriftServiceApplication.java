package com.spring.boot.study.thrift;

import com.spring.boot.study.thrift.service.ThriftServiceServer;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ThriftServiceApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ThriftServiceApplication.class, args);
        try {
            ThriftServiceServer thriftServiceServer = context.getBean(ThriftServiceServer.class);
            new Thread(thriftServiceServer).start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
