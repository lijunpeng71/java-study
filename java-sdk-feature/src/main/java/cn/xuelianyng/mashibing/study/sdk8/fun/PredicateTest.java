package cn.xuelianyng.mashibing.study.sdk8.fun;

import java.util.function.Predicate;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 21:36
 */
public class PredicateTest {


    private static void test(Predicate<String> p, String msg) {
        boolean b = p.test(msg);
        System.out.println("b:" + b);
    }

    public static void main(String[] args) {
        test(msg -> msg.length() > 3, "1235");
    }
}
