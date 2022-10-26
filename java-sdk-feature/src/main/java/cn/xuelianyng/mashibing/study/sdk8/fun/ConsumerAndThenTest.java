package cn.xuelianyng.mashibing.study.sdk8.fun;

import java.util.function.Consumer;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 20:34
 */
public class ConsumerAndThenTest {

    public static void test(Consumer<String> c1, Consumer<String> c2) {
        String str = "Hello World";
        c2.andThen(c1).accept(str);
    }

    public static void main(String[] args) {
        test(msg1 -> System.out.println("msg1:" + msg1 + "\t转小写 msg1:" + msg1.toLowerCase()),
                msg1 -> System.out.println("msg1:" + msg1 + "\t转大写 msg1:" + msg1.toUpperCase()));
    }
}
