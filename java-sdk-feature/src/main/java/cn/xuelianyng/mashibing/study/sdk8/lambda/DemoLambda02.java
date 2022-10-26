package cn.xuelianyng.mashibing.study.sdk8.lambda;

import cn.xuelianyng.mashibing.study.sdk8.lambda.service.UserService;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 18:01
 */
public class DemoLambda02 {
    public static void main(String[] args) {
        //非lambda方式
        goShow(new UserService() {
            @Override
            public void show() {
                System.out.println("show 方法执行了...");
            }
        });
        System.out.println("----------");
        //lambda方式
        goShow(() -> { System.out.println("Lambda show 方法执行了..."); });
    }

    public static void goShow(UserService userService){
        userService.show();
    }
}
