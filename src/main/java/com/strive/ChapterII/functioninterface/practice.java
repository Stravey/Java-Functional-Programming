package com.strive.ChapterII.functioninterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class practice {

    public static void main(String[] args) {
        filter(List.of(1,2,3,4,5),(Integer number) -> (number & 1) == 0);

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









}
