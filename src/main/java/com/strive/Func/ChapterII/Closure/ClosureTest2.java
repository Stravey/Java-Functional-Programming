package com.strive.Func.ChapterII.Closure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("all")
public class ClosureTest2 {
    public static void main(String[] args) throws IOException {
        //创建10个任务对象，并且每一个任务对象给一个任务编号
        //任务对象需放到线程池中
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //i本身是变化的，不能作为闭包里的外部变量（因为要满足final或着effectively final）
            //解决方法就是将i赋给一个新的变量保持不变 就可以组成闭包
            int k = i + 1;
            Runnable task = () -> System.out.println(Thread.currentThread() + "执行任务" + k);
            list.add(task);
        }

        //创建线程池
        ExecutorService service = Executors.newVirtualThreadPerTaskExecutor();
        for (Runnable task : list) {
            //向线程池中提交任务对象
            service.submit(task);
        }
        //让主线程不要停止
        System.in.read();
    }
}
