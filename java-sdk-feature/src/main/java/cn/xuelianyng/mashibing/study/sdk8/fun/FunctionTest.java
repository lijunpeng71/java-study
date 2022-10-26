package cn.xuelianyng.mashibing.study.sdk8.fun;

import java.util.function.Function;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 21:10
 */
public class FunctionTest {

    private static Integer test(Function<String, Integer> function) {
        Integer num = function.apply("666");
        return num;
    }

    public static void main(String[] args) {
        test(numStr -> Integer.parseInt(numStr));
    }
}
