package com.spring.cloud.study.order.controller;

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

    @Override
    public Result<Order> getById(Long id) {
        log.info("order-getById");
        if (id < 0) {
            throw new RuntimeException();
        }
        Order order = orderService.getById(id);
        return Result.success(order);
    }

    @Override
    public Result<Boolean> create(Order order) {
        orderService.create(order);
        return Result.success(Boolean.TRUE);
    }
}
