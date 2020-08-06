package com.spring.cloud.study.portal.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <b><code>OrderVO</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/6 13:51.
 *
 * @author xxx
 * @since java-study
 */
@Data
public class OrderVO implements Serializable {

    private Long id;

    private String no;

    private Date createTime;

    private Byte status;

}
