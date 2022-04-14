package com.xuelianyong.interview.stream.study;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @program: java-study
 * @description:
 * @author: junpeng.li
 * @create: 2021-08-23 14:37
 **/
public class StreamDemo {

    /**
     * 获取数据
     *
     * @return
     */
    public static List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(null, "小明"));
        studentList.add(new Student(null, "小红"));
        studentList.add(new Student(null, "小强"));
        return studentList;
    }

    public static void listToMap() {
        List<Student> studentList = getStudentList();
        Map<Integer, Student> studentMap = new HashMap<>();
        if (CollectionUtil.isNotEmpty(studentList)) {
            studentMap = studentList.stream().collect(Collectors.toMap(student -> student.getId(), Function.identity(), (k, v) -> v));
        }
        if (MapUtil.isNotEmpty(studentMap)) {
            studentMap.forEach((key, value) -> System.out.println("key:" + key + "\t" + "value:" + value));
        }
    }

    public static void main(String[] args) {
        listToMap();
    }
}

/**
 * 学生类(用于构造测试数据)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    /**
     * id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String username;
}
