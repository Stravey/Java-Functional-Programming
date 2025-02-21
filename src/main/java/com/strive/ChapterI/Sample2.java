package com.strive.ChapterI;

import java.util.ArrayList;
import java.util.List;

public class Sample2 {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("111",18,"男"),
                new Student("222",16,"女"),
                new Student("333",19,"女"),
                new Student("444",20,"男")
        );

        //返回男性学生
        System.out.println(filter(students));
        System.out.println(filter0(students,student -> student.sex.equals("男")));

        //筛选18岁以下的学生
        System.out.println(filter2(students));
        System.out.println(filter0(students,student -> student.age < 18));
    }

    interface Lambda{
        boolean test(Student student);
    }

    static List<Student> filter0(List<Student> students,Lambda lambda) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (lambda.test(student)) {
                result.add(student);
            }
        }
        return result;
    }

    // 函数 ：参数 —> 逻辑部分
    // student -> student.sex.equals("男")
    static List<Student> filter(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.sex.equals("男")) {
                result.add(student);
            }
        }
        return result;
    }

    // student -> student.age < 18
    static List<Student> filter2(List<Student> students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.age < 18) {
                result.add(student);
            }
        }
        return result;
    }

    static class Student {
        String name;
        int age;
        String sex;

        public Student(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex='" + sex + '\'' +
                    '}';
        }
    }
}
