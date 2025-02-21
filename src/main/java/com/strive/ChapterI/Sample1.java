package com.strive.ChapterI;

public class Sample1 {

    //普通函数
    static int add(int a, int b) {
        return a + b;
    }

    interface Lambda{
        int calculate(int a, int b);
    }

    //函数化为对象
    static Lambda add = (a, b) -> a + b;

    /*
     * 1.普通函数位置固定，使用要通过Sample.add找到它
     * 2.函数化为对象，位置可以变化，将接口里的参数作为对象传进去
     * 3.接口的目的是为了将来用它执行函数对象，此接口中只能有一个方法定义
     */

    public static void main(String[] args) {
        System.out.println(Sample1.add(3,4));
        System.out.println(add.calculate(5, 6));
    }

}
