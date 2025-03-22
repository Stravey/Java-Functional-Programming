package com.strive.Func.ChapterII.Currying;

public class CurryingTest1 {
    @FunctionalInterface
    interface F2 {
        int op(int a,int b);
    }

    @FunctionalInterface
    interface Fa {
        Fb op(int a);
    }

    @FunctionalInterface
    interface Fb {
        int op(int b);
    }

    public static void main(String[] args) {
        //两个参数的函数对象
        F2 f2 = (a, b) -> a + b;
        System.out.println(f2.op(10, 20));

        /*
            (a) -> 返回另一个函数对象(b)
            (b) -> a + b
         */
        Fa fa = (a) -> (b) -> a + b;
        Fb fb = fa.op(10);
        int sum = fb.op(20);
        System.out.println(sum);
    }
}
