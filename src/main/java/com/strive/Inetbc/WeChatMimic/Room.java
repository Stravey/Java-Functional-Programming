package com.strive.Inetbc.WeChatMimic;

import java.util.Scanner;

public class Room {
    public static void main(String[] args) {
        System.out.println("模拟微信聊天开始");
        Scanner input = new Scanner(System.in);
        System.out.println("输入你的微信号：");
        int sendPort = input.nextInt();
        System.out.println("将消息发送给哪个微信：");
        int receivePort = input.nextInt();
        System.out.println("微信聊天现在开始...");

        // 发送数据线程
        new Thread(new SendTask(sendPort)).start();
        // 接收数据线程
        new Thread(new ReceiveTask(receivePort)).start();
    }
}
