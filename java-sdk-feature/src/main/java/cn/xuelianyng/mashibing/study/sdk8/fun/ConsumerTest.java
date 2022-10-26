package cn.xuelianyng.mashibing.study.sdk8.fun;

import java.util.function.Consumer;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 20:22
 */
public class ConsumerTest {

    private static void test(Consumer<String> customer) {
        customer.accept("Hello,world");
    }

    private static void test2(Consumer<String> c1, Consumer<String> c2) {
        String str = "Hello World";
        c1.accept(str);
        c2.accept(str);
    }

    public static void main(String[] args) {
        test(msg -> System.out.println("msg:" + msg + "\t转换后msg:" + msg.toLowerCase()));
        test2(msg1 -> System.out.println("msg1:" + msg1 + "\t转小写 msg1:" + msg1.toLowerCase()), msg2 -> System.out.println("msg2:" + msg2 + "\t转大写 msg2:" + msg2.toUpperCase()));
    }
}
