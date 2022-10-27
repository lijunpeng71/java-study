package cn.xuelianyng.mashibing.study.sdk8.funref;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author lijunpeng02
 * @date 2022年10月27日 11:00
 */
public class FunctionRefTest05 {
    public static void main(String[] args) {
        //普通方法
        Function<String, Integer> function = s -> s.length();
        System.out.println(function.apply("hello"));
        //方法引用
        Function<String, Integer> refFunction = String::length;
        System.out.println(refFunction.apply("hahahaha"));

        //使用第一个参数作为引用
        BiFunction<String, Integer, String> refFunction2 = String::substring;
        String msg = refFunction2.apply("Hello,World", 3);
        System.out.println(msg);
    }
}
