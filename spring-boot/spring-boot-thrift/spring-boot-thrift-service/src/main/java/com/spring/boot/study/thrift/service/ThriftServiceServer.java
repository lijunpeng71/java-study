package com.spring.boot.study.thrift.service;

import com.spring.boot.study.thrift.client.DataService;
import com.spring.boot.study.thrift.service.impl.DataCoreService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ThriftServiceServer implements Runnable {

    @Resource
    private DataCoreService dataCoreService;

    @Override
    public void run() {
        try {
            //Thrift服务端口号
            TServerTransport serverTransport = new TServerSocket(8888);
            //提供的服务实现
            TProcessor processor = new DataService.Processor<DataService.Iface>(dataCoreService);
            //协议工厂
            TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
            TTransportFactory transportFactory = new TTransportFactory();
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(serverTransport);
            tArgs.processor(processor);
            tArgs.protocolFactory(protocolFactory);
            tArgs.transportFactory(transportFactory);
            TServer server = new TThreadPoolServer(tArgs);
            System.out.println("Starting the simple server...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
