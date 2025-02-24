package com.strive.ChapterIII.methodreference;

import java.util.stream.Stream;

public class methodRef1 {
    public static void main(String[] args) {
        Stream.of(
                new Student("111","男"),
                new Student("222","男"),
                new Student("333","女")
        ).filter(methodRef1::isMale)
                //.filter((Student stu) -> stu.sex().equals("男"))
                //.Lambda表达式
                //.forEach((Student stu) -> System.out.println(stu));

                //.方法引用
                .forEach(methodRef1::abc);

        /*
            (Student stu) -> System.out.println(stu)
            (Student stu) -> stu.sex().equals("男")
         */
    }

    public static boolean isMale(Student s) {
        return s.sex().equals("男");
    }

    public static void abc(Student s) {
        System.out.println(s);
    }

    //record类用来创建不可变的对象
    record Student(String Name, String sex) {
    }

}
