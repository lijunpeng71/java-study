package com.spring.cloud.study.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.spring.cloud.study.common.result.Result;
import com.spring.cloud.study.order.client.OrderClient;
import com.spring.cloud.study.order.model.Order;
import com.spring.cloud.study.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <b><code>OrderController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/6 10:39.
 *
 * @author xxx
 * @since java-study
 */
@RestController
@Slf4j
public class OrderController implements OrderClient {

    @Resource
    private OrderService orderService;

    @HystrixCommand(fallbackMethod = "getByIdFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
    })
    @Override
    public Result<Order> getById(Long id) {
        log.info("order-getById");
        if (id < 0) {
            throw new RuntimeException();
        }
        Order order = orderService.getById(id);
        return Result.success(order);
    }

    public Result<Order> getByIdFallback(Long id) {
        return Result.fail("order-hystrix");
    }

    @Override
    public Result<Boolean> create(Order order) {
        orderService.create(order);
        return Result.success(Boolean.TRUE);
    }
}
