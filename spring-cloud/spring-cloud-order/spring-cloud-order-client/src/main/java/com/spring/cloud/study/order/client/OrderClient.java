package com.spring.cloud.study.order.client;

import com.spring.cloud.study.common.result.Result;
import com.spring.cloud.study.order.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <b><code>OrderClient</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 14:41.
 *
 * @author xxx
 * @since java-study
 */
@FeignClient(value = "spring-cloud-order")
public interface OrderClient {

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/order/getById/{id}")
    Result<Order> getById(@PathVariable(value = "id") Long id);

    /**
     * 创建
     *
     * @param order
     * @return
     */
    @PostMapping(value = "/order/create")
    Result<Boolean> create(@RequestBody Order order);
}
