package com.spring.cloud.study.portal.controller;

import com.spring.cloud.study.common.result.Result;
import com.spring.cloud.study.order.client.OrderClient;
import com.spring.cloud.study.order.model.Order;
import com.spring.cloud.study.portal.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <b><code>OrderController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 11:03.
 *
 * @author xxx
 * @since java-study
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Resource
    private OrderClient orderClient;

    @GetMapping(value = "getById/{id}")
    public Result<OrderVO> getById(@PathVariable(value = "id") Long id) {
        log.info("portal-getById");
        Result<Order> orderResult = orderClient.getById(id);
        OrderVO orderVO = null;
        if (orderResult.isOk()) {
            Order order = orderResult.getData();
            orderVO = new OrderVO();
            orderVO.setId(order.getId());
            orderVO.setNo(order.getNo());
            orderVO.setCreateTime(order.getCreateTime());
            orderVO.setStatus(order.getStatus());
            return Result.success(orderVO);
        } else {
            return Result.fail(orderResult.getMsg());
        }
    }
}
