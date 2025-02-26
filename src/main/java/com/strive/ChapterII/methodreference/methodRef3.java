package com.strive.ChapterII.methodreference;

import java.util.stream.Stream;

//第三种方法引用的形式：对象::非静态方法
public class methodRef3 {

    static class Util {
        public boolean isMale(Student stu) {
            return stu.sex.equals("女");
        }

        public String toName(Student stu) {
            return stu.name;
        }
    }

    public static void main(String[] args) {
        Util util = new Util();
        Stream.of(
                new Student("222","女"),
                new Student("666","女"),
                new Student("333","男"),
                new Student("777","女")
        )
                .filter(util::isMale)
                .map(util::toName)
                .forEach(System.out::println);

    }

    /*
        对象的非静态方法
        System.out::println
        stu -> System.out.println(stu)
     */

    //自动生成get方法并创建对象
    record Student(String name,String sex) {
        public String name() {
            return name;
        }

        public String sex() {
            return sex;
        }
    }

}
