package com.strive.ChapterII.functioninterface;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class second_case {
    static class Teacher {
        private String name;
        private int age;

        public Teacher() {
        }

        public Teacher(String name) {
            this.name = name;
        }

        public Teacher(String name, int age) {
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
            Teacher teacher = (Teacher) o;
            return age == teacher.age && Objects.equals(name, teacher.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    //使用jdk中的函数对象Lambda表达式接口
    public static void main(String[] args) {
        //IntPredicate接口
        IntPredicate obj1 = (int a) -> (a & 1) == 0;
        IntPredicate obj2 = (int a) -> BigInteger.valueOf(a).isProbablePrime(100);
        //IntBinaryOperator接口
        IntBinaryOperator obj3 = (int a, int b) -> a - b;
        IntBinaryOperator obj4 = (int a, int b) -> a * b;
        obj5 = (int a, int b, int c) -> a + b - c;
        //Supplier接口
        Supplier<Teacher> onj6 = () -> new Teacher();
        Supplier<List<Teacher>> obj7 = () -> new ArrayList<Teacher>();
        //Function接口
        Function<Teacher, Integer> obj8 = (Teacher s) -> s.getAge();
        Function<Teacher, String> obj9 = (Teacher s) -> s.getName();
    }

}
