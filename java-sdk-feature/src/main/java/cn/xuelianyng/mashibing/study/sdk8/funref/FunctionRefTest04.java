package cn.xuelianyng.mashibing.study.sdk8.funref;

import java.util.function.Supplier;

/**
 * @author lijunpeng02
 * @date 2022年10月27日 10:55
 */
public class FunctionRefTest04 {
    public static void main(String[] args) {
        //普通方法
        Supplier<Long> supplier = () -> System.currentTimeMillis();
        System.out.println(supplier.get());
        //方法引用
        Supplier<Long> refSupplier = System::currentTimeMillis;
        System.out.println(refSupplier.get());
    }
}
