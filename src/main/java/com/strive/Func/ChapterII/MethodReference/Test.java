package com.strive.Func.ChapterII.MethodReference;

import com.strive.Func.ChapterII.MethodReference.methodRef5;

import java.io.File;
import java.util.function.Function;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    public static void main(String[] args) {

        //Function<String,Integer> lambda = (String s) -> Integer.parseInt(s);
        Function<String,Integer> lambda = Integer::parseInt;

        //BiPredicate<List<String>,String> abc = (list,element) -> list.contains(element);
        BiPredicate<List<String>,String> abc = List::contains;

        //BiPredicate<Student,Object> xyz = (stu,obj) -> stu.equals(obj);
        BiPredicate<methodRef5.Student,Object> xyz = Record::equals;

        //Predicate<File> mn = (file) -> file.exists();
        Predicate<File> mn = File::exists;

        //Runtime runtime = Runtime.getRuntime();
        Runtime runtime = Runtime.getRuntime();

        //Supplier<Long> t = () -> runtime.freeMemory();
        Supplier<Long> t = Runtime.getRuntime()::freeMemory;

        TernaryFunction a = Color::new;
        Color white = a.create(255,255,255);
        System.out.println(white);

    }

    record Color(Integer red, Integer green, Integer blue) {
        //使用Color::new
    }

    @FunctionalInterface
    interface TernaryFunction {
        Color create(Integer a, Integer b, Integer c);
    }
}
