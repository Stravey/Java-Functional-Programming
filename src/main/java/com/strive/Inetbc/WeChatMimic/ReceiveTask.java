package com.strive.Inetbc.WeChatMimic;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 接受数据的任务类
 */

public class ReceiveTask implements Runnable {

    private final int receivePort;

    public ReceiveTask(int receivePort) {
        this.receivePort = receivePort;
    }

    @Override
    public void run() {
        try {
            // 1.创建ds对象
            DatagramSocket ds = new DatagramSocket(receivePort);
            // 2.创建dp对象
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf,buf.length);
            // 3.完成数据的接收
            while (true) {
                // 4.启动监听数据
                ds.receive(dp);
                // 5.读取数据操作
                String msg = new String(dp.getData(),0,dp.getLength());
                System.out.println(dp.getAddress().getHostAddress() + ":" + dp.getPort() + ":" + msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
