package cn.xuelianyng.mashibing.study.sdk8.lambda;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 17:48
 */
public class DemoLambda01 {
    public static void main(String[] args) {
        //开启一个新线程
        new Thread(new Runnable() {
            public void run() {
                System.out.println("新线程中执行的代码 : " + Thread.currentThread().getName());
            }
        }).start();
        System.out.println("主线程中的代码：" + Thread.currentThread().getName());
        System.out.println("---------------");
    }
}
