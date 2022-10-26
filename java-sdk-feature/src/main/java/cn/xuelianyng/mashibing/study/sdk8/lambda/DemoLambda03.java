package cn.xuelianyng.mashibing.study.sdk8.lambda;

import cn.xuelianyng.mashibing.study.sdk8.lambda.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lijunpeng02
 * @date 2022年10月26日 18:11
 */
public class DemoLambda03 {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("周杰伦", 33, 175));
        list.add(new Person("刘德华", 43, 185));
        list.add(new Person("周星驰", 38, 177));
        list.add(new Person("郭富城", 23, 170));
        ArrayList<Person> commonPersons = (ArrayList<Person>) list.clone();
        ArrayList<Person> lambdaPersons= (ArrayList<Person>) list.clone();
        System.out.println("普通方式排序结果：");
        commonSort(commonPersons);
        System.out.println("lambda方式排序结果：");
        lambdaSort(lambdaPersons);
    }

    /**
     * 普通排序
     *
     * @param persons
     * @return
     */
    public static List<Person> commonSort(List<Person> persons) {
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Person person : persons) {
            System.out.println(person);
        }
        return persons;
    }

    /**
     * lambda排序
     *
     * @param persons
     * @return
     */
    public static List<Person> lambdaSort(List<Person> persons) {
        Collections.sort(persons, (o1, o2) -> o1.getAge() - o2.getAge());
        for (Person person : persons) {
            System.out.println(person);
        }
        return persons;
    }
}
