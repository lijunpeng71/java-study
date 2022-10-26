package cn.xuelianyng.mashibing.study.sdk8.fun;

import java.util.function.Predicate;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 21:42
 */
public class PredicateDefaultTest {


    public static void main(String[] args) {
        test(msg1 -> msg1.contains("H"), msg2 -> msg2.contains("W"));
    }

    private static void test(Predicate<String> p1, Predicate<String> p2) {
        // p1 包含H 同时 p2 包含W
        boolean bb1 = p1.and(p2).test("Hello");
        // p1 包含H 或者 p2 包含W
        boolean bb2 = p1.or(p2).test("Hello");
        // p1 不包含H
        boolean bb3 = p1.negate().test("Hello");
        // FALSE
        System.out.println(bb1);
        // TRUE
        System.out.println(bb2);
        // FALSE
        System.out.println(bb3);
    }
}
