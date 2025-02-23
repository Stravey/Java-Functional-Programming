package com.strive.ChapterII.functioninterface;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class first_case {

    static class Student {
        private String name;
        private int age;

        public Student() {
        }

        public Student(String name) {
            this.name = name;
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }


    public static void main(String[] args) {
        first_Type obj1 = (int a) -> (a & 1) == 0;
        first_Type obj2 = (int a) -> BigInteger.valueOf(a).isProbablePrime(100);
        second_Type obj3 = (int a,int b) -> a - b;
        second_Type obj4 = (int a,int b) -> a * b;
        third_Type obj5 = (int a,int b,int c) -> a + b - c;
        fourth_Type<Student> onj6 = () -> new Student();
        fourth_Type<List<Student>> obj7 = () -> new ArrayList<Student>();
        fifth_Type<Integer,Student> obj8 = (Student s) -> s.getAge();
        fifth_Type<String,Student> obj9 = (Student s) -> s.getName();

    }

    //注解检查编译期间检查接口内是否只有一个抽象方法
    @FunctionalInterface
    interface first_Type {
        boolean first(int a);
    }

    @FunctionalInterface
    interface second_Type {
        int second(int a,int b);
    }

    @FunctionalInterface
    interface third_Type {
        int third(int a,int b,int c);
    }

    @FunctionalInterface
    interface fourth_Type<T> {
        T ha();
    }

    @FunctionalInterface
    interface fifth_Type<O,I> {
        O he(I input);
    }


}
