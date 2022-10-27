package cn.xuelianyng.mashibing.study.sdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lijunpeng02
 * @date 2022年10月27日 14:47
 */
public class StreamTest01 {
    public static void main(String[] args) {

    }

    public static void commonMethod() {
        // 定义一个List集合
        List<String> list = Arrays.asList("张三", "张三丰", "成龙", "周星驰");
        // 1.获取所有 姓张的信息
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("张")) {
                list1.add(s);
            }
        }
        // 2.获取名称长度为3的用户
        List<String> list2 = new ArrayList<>();
        for (String s : list1) {
            if (s.length() == 3) {
                list2.add(s);
            }
        }
        // 3. 输出所有的用户信息
        for (String s : list2) {
            System.out.println(s);
        }
    }

    public static void streamMethod() {
        // 定义一个List集合
        List<String> list = Arrays.asList("张三", "张三丰", "成龙", "周星驰");
        // 1.获取所有 姓张的信息
        // 2.获取名称长度为3的用户
        // 3. 输出所有的用户信息
        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(s -> {
                    System.out.println(s);
                });
        System.out.println("----------");
        // 方法引用
        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(System.out::println);
    }
}
