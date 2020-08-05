package com.spring.cloud.study.order.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <b><code>Order</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 14:41.
 *
 * @author xxx
 * @since java-study
 */
@Data
@TableName("biz_order")
@FieldNameConstants
public class Order implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private String no;

    /**
     * 金额
     */
    private BigDecimal price;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 订单状态
     */
    private Byte status;
}



