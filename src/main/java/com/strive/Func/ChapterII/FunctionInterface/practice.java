package com.strive.Func.ChapterII.FunctionInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 函数接口练习
// 使用jdk的函数接口实现Lambda表达式
public class practice {

    public static void main(String[] args) {
        List<Integer> result = filter(List.of(1,2,3,4,5),(Integer number) -> (number & 1) == 0);
        System.out.println(result);

        List<String> map = map(List.of(1,2,3,4,5,6,7,8,9),(Integer number) -> String.valueOf(number));
        System.out.println(map);

        consume(List.of(1,2,3,4,5,6,7),(Integer number) -> System.out.print(number + " "));

        List<Integer> supply = supply(5,() -> ThreadLocalRandom.current().nextInt());
        System.out.println(supply);
    }

    static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for(Integer number : list) {
            //判断是否是偶数
            if(predicate.test(number)) {
                result.add(number);
            }
        }
        return result;
        /*
            (Integer number) -> (number & 1) == 0
         */
    }

    static List<String> map(List<Integer> list, Function<Integer,String> function) {
        List<String> result = new ArrayList<>();
        for (Integer number : list){
            //使用字符串进行输出
            result.add(function.apply(number));
        }
        return result;
        /*
            (Integer number) -> String.valueOf(number)
         */
    }

    static void consume(List<Integer> list, Consumer<Integer> consumer) {
        for(Integer number : list) {
            //使用系统输出数字
            consumer.accept(number);
        }
        /*
            (Integer number) -> System.out.println(number)
         */
    }

    static List<Integer> supply(int count, Supplier<Integer> supplier) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            //生成随机数，以后可能变
            result.add(supplier.get());
        }
        return result;
        /*
            () -> ThreadLocalRandom.current().nextInt()
         */
    }

}
