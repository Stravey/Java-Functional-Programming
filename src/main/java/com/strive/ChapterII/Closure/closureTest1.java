package com.strive.ChapterII.Closure;

//闭包
public class closureTest1 {

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
        int x = 10;
        Order((int y) -> x + y);
        Order((int y) -> a + y);
        //闭包不能使用非静态变量
        //Order((int y) -> b + y);
    }
}
