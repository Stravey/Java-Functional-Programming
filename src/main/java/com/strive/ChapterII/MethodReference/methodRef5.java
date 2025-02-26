package com.strive.ChapterII.MethodReference;

import java.util.stream.Stream;

public class methodRef5 {
    public static void main(String[] args) {
        //Util util = new Util();
        Util util = new utilExt();
        util.hiOrder(Stream.of(
                new Student("111","男"),
                new Student("222","女"),
                new Student("333","男")
        ));
    }

    record Student(String name,String sex){
    }

    static class Util{
        public boolean isMale(Student s) {
            return s.sex.equals("男");
        }

        void hiOrder(Stream<Student> stream) {
            stream  .filter(this::isMale)
                    .forEach(System.out::println);
        }

    }

    static class utilExt extends Util{
        public boolean isFemale(Student s) {
            return s.sex.equals("女");
        }

        void hiOrder(Stream<Student> stream) {
            stream.filter(this::isFemale)
                    .forEach(System.out::println);
        }
    }

}
