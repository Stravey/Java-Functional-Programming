package com.strive.Func.ChapterII.Closure;

//闭包
//可以使用静态变量 成员变量 方法参数变量  不能使用非静态变量
public class ClosureTest1 {

    @FunctionalInterface
    interface Lambda {
        int op(int y);
    }

    static void Order(Lambda lambda) {
        System.out.println(lambda.op(1));
    }

    static int a = 10;
    int b = 3;

    public static void main(String[] args) {
        final int x = 10;
        Order((int y) -> x + y);
        Order((int y) -> a + y);
        //闭包不能使用非静态变量
        //Order((int y) -> b + y);
        Student stu = new Student(18);
        Lambda lambda = y -> y + stu.d;
        Order(lambda);

        stu.d = 30;
        Order(lambda);
    }

    static class Student {
        int d;

        public Student(int d) {
            this.d = d;
        }

    }

    public void test(int c) {
        Order(y-> a + y); //静态变量
        Order(y-> b + y); //成员变量
        Order(y-> c + y); //方法参数变量
    }

}
