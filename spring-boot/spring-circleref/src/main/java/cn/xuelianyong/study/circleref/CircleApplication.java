package cn.xuelianyong.study.circleref;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lijunpeng02
 * @date 2022年12月05日 19:23
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.xuelianyong","com.sankuai.nibscp.meishi.taskcenter"})
public class CircleApplication {
    public static void main(String[] args) {
        SpringApplication.run(CircleApplication.class, args);
    }
}
