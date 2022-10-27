package cn.xuelianyng.mashibing.study.sdk8.funref;

import java.util.function.Function;

/**
 * @author lijunpeng02
 * @date 2022年10月27日 11:27
 */
public class FunctionRefTest07 {
    public static void main(String[] args) {
        //普通方式
        Function<Integer, String[]> fun1 = len -> new String[len];
        String[] a1 = fun1.apply(3);
        System.out.println("数组长度:" + a1.length);
        //方法引用方式
        Function<Integer, String[]> fun2 = String[]::new;
        String[] a2 = fun2.apply(3);
        System.out.println("数字长度:" + a2.length);
    }
}
