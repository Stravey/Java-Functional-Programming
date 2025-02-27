package com.strive.ChapterII.HiOrderFunction;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

//集合内循环
public class InnerLoop {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //逆序遍历集合
        hiOrder(list,System.out::println);
    }

    //高阶函数
    public static <T> void hiOrder(List<T> list, Consumer<T> consumer) {
        ListIterator<T> iterator = list.listIterator(list.size());
        while(iterator.hasPrevious()) {
            T value = iterator.previous();
            consumer.accept(value);
        }
    }
}
