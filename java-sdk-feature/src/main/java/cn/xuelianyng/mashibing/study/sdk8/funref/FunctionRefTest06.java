package cn.xuelianyng.mashibing.study.sdk8.funref;

import cn.xuelianyng.mashibing.study.sdk8.lambda.model.Person;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author lijunpeng02
 * @date 2022年10月27日 11:13
 */
public class FunctionRefTest06 {
    public static void main(String[] args) {
        //普通方式
        Supplier<Person> supplier = () -> new Person();
        System.out.println(supplier.get());
        //方法引用实现
        Supplier<Person> refSupplier = Person::new;
        System.out.println(refSupplier.get());
        //有两个入参的引用方式实现
        BiFunction<String, Integer, Person> function = Person::new;
        System.out.println(function.apply("张三", 22));
    }
}
