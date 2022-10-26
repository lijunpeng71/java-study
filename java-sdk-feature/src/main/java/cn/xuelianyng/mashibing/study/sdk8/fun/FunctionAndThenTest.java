package cn.xuelianyng.mashibing.study.sdk8.fun;

import java.util.function.Function;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 21:15
 */
public class FunctionAndThenTest {

    private static Integer test(Function<String, Integer> f1, Function<Integer, Integer> f2) {
        Integer num = f1.andThen(f2).apply("666");
        System.out.println(num);
        return num;
    }

    public static void main(String[] args) {
        test(numStr -> Integer.parseInt(numStr), num -> num * 10);
    }
}
