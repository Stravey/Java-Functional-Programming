package com.strive.Func.ChapterII.MethodReference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class methodRef4 {

    static class Student {
        private final String name;
        private final Integer age;

        public Student() {
            this.name = null;
            this.age = null;
        }

        public Student(String name) {
            this.name = name;
            this.age = 18;
        }

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        //调用一个参数的构造
        Supplier<Student> s1 = Student::new;
        //调用两个参数的构造
        Function<String,Student> s2 = Student::new;
        //调用三个参数的构造
        BiFunction<String,Integer,Student> s3 = Student::new;

        System.out.println(s1.get());
        System.out.println(s2.apply("张三"));
        System.out.println(s3.apply("李四",19));
    }

}
