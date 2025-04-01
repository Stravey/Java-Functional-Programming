package com.strive.Inetbc.WeChatMimic;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * 发送数据的任务类
 */

public class SendTask implements Runnable {

    // 创建一个存储端口号的变量
    private final int sendPort;

    // 构造方法
    public SendTask(int sendPort) {
        this.sendPort = sendPort;
    }

    @Override
    public void run() {
        try {
            // 1.
            DatagramSocket ds = new DatagramSocket();
            // 2.构建dp的参数列表
            Scanner input = new Scanner(System.in);
            // 3.通过循环结构
            while (true) {
                String data = input.nextLine();
                byte[] bytes = data.getBytes();
                InetAddress address = InetAddress.getByName("127.0.0.1");
                // 4.创建dp对象
                DatagramPacket dp = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("127.0.0.1"),sendPort);
                // 5.发送数据
                ds.send(dp);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
