package com.strive.Func.ChapterII.HiOrderFunction;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStream<T> {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);

        SimpleStream.of(list)
                .filter(x -> (x & 1) == 1)
                .map(x -> x * x);
    }

    public SimpleStream<T> filter(Predicate<T> predicate) {
        return this;
    }

    public SimpleStream<T> map(Function<? super T, ? extends T> mapper) {
        return this;
    }

    public SimpleStream<T> forEach(Function<? super T, ? extends List<? extends T>> mapper) {
        return this;
    }

    public static <T> SimpleStream<T> of(Collection<T> collection) {
        return new SimpleStream<>(collection);
    }

    private Collection<T> collection;
    public SimpleStream(Collection<T> collection) {
        this.collection = collection;
    }
}
