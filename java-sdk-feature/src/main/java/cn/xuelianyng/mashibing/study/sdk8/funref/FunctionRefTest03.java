package cn.xuelianyng.mashibing.study.sdk8.funref;

import java.util.Date;
import java.util.function.Supplier;

/**
 * @author lijunpeng02
 * @date 2022年10月27日 10:51
 */
public class FunctionRefTest03 {
    public static void main(String[] args) {
        Date now = new Date();
        //普通方式
        Supplier<Long> supplier = () -> now.getTime();
        System.out.println(supplier.get());
        //通过方法引用方式
        Supplier<Long> refSupplier = now::getTime;
        System.out.println(refSupplier.get());
    }
}
