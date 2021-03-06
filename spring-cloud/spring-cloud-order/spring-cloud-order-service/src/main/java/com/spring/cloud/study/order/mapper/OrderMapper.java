package com.spring.cloud.study.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spring.cloud.study.order.model.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <b><code>OrderMapper</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 15:28.
 *
 * @author xxx
 * @since java-study
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
