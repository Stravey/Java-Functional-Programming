package com.strive.ChapterII.MethodReference;

import java.util.stream.Stream;

//第二种方法引用形式：类名::非静态方法
public class methodRef2 {
    public static void main(String[] args) {
        Stream.of(      new Student("111","男"),
                        new Student("222","男"),
                        new Student("333","女")
                        //filter方法为非静态方法的方法引用（学生即对象类中的方法）
                ).filter(Student::isMale)
                //下面这种为静态方法的方法引用（类中的静态方法）
                //.filter(methodRef1::isMale)

                //.filter((Student stu) -> stu.sex().equals("男"))
                //.Lambda表达式
                //.forEach((Student stu) -> System.out.println(stu));

                //.方法引用
                //下面这种为静态方法的方法引用（类中的静态方法）
                //.forEach(methodRef1::abc);
                //abc方法为非静态方法的方法引用（学生即对象类中的方法）
                .forEach(Student::abc);

        /*
            (Student stu) -> System.out.println(stu)
            (Student stu) -> stu.sex().equals("男")
         */
    }
    //record类用来创建不可变的对象
    record Student(String Name, String sex) {
        public boolean isMale() {
            return this.sex.equals("男");
        }
        /*
            Student::isMale
            (stu) -> stu.isMale
         */
        public void abc() {
            System.out.println(this);
        }
        /*
            Student::abc
            (stu) -> stu.abc()
         */
    }
}
