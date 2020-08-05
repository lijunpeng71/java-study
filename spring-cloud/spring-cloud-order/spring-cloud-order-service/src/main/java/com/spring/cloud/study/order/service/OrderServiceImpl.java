package com.spring.cloud.study.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.cloud.study.order.mapper.OrderMapper;
import com.spring.cloud.study.order.model.Order;
import org.springframework.stereotype.Service;

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
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
