package com.spring.cloud.study.order.service;

import com.spring.cloud.study.order.mapper.OrderMapper;
import com.spring.cloud.study.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <b><code>OrderServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 15:30.
 *
 * @author xxx
 * @since java-study
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public Order getById(Long id) {
        Order order = orderMapper.selectById(id);
        return order;
    }

    @Override

    public Order create(Order order) {
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderMapper.insert(order);
        return order;
    }
}
