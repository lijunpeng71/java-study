package com.spring.cloud.study.order.service;

import com.spring.cloud.study.order.model.Order;

/**
 * <b><code>OrderService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 15:29.
 *
 * @author xxx
 * @since java-study
 */
public interface OrderService {

    /**
     * 查询
     *
     * @param id
     * @return
     */
    Order getById(Long id);

    /**
     * 创建
     *
     * @param order
     * @return
     */
    Order create(Order order);
}
