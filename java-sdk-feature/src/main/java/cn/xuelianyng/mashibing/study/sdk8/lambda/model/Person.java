package cn.xuelianyng.mashibing.study.sdk8.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 18:09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    private String name;

    private Integer age;

    private Integer height;

}
