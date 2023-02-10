package cn.xuelianyong.study.nuxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lijunpeng02
 * @date 2023年02月10日 19:43
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cn.xuelianyong"})
public class NuxtApplication {
    public static void main(String[] args) {
        SpringApplication.run(NuxtApplication.class, args);
    }
}
