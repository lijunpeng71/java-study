package cn.xuelianyng.mashibing.study.sdk8.fun;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 20:15
 */
public class SupplierTest {

    private static void fun1(Supplier<Integer> supplier) {
        Integer max = supplier.get();
        System.out.println("max=" + max);
    }

    public static void main(String[] args) {
        fun1(() -> {
            int arr[] = {22, 33, 55, 66, 44, 99, 10};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }
}
