package cn.xuelianyng.mashibing.study.sdk8.funref;

import java.util.function.Consumer;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 21:46
 */
public class FunctionRefTest01 {

    /**
     * 求数组中的所有元素的和
     *
     * @param arr
     */
    public static void getTotal(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        System.out.println("数组之和：" + sum);
    }

    private static void printMax(Consumer<int[]> consumer) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        consumer.accept(arr);
    }

    public static void main(String[] args) {
        printMax(arr -> {
            // Lambda表达式中的代码和 getTotal中的代码冗余了
            int sum = 0;
            for (int i : arr) {
                sum += i;
            }
            System.out.println("数组之和：" + sum);
        });
        // :: 方法引用 也是JDK8中的新的语法
        printMax(FunctionRefTest01::getTotal);
    }
}
