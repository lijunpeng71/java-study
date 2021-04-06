package com.spring.boot.study.thrift.client;

import com.spring.boot.study.common.result.InvokeResult;
import org.apache.thrift.TConfiguration;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftServiceClient {

    /**
     * 请求thrift服务端
     *
     * @param host           服务端地址
     * @param port           端口
     * @param value          传值
     * @param socketTimeout  传输超时
     * @param connectTimeout 连接超时
     */
    public static InvokeResult getResult(String host, int port, String value, int socketTimeout, int connectTimeout) throws Exception {

        InvokeResult res;
        TTransport transport = null;
        try {
            TConfiguration configuration = new TConfiguration();
            transport = new TSocket(configuration, host, port, socketTimeout, connectTimeout);
            TProtocol protocol = new TBinaryProtocol(transport);
            DataService.Client client = new DataService.Client(protocol);
            transport.open();
            res = client.DataCore(value);
        } catch (Exception ex) {
            throw ex;
        }
        finally {
            if (transport != null) {
                transport.close();
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 8888;
        int socketTimeout = 2000;
        int connectTimeout = 2000;
        InvokeResult result = getResult(host, port, "1", socketTimeout, connectTimeout);
        System.out.println("result.data:" + result.getData());
    }
}
