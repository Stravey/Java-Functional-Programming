package com.strive.Inetbc.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 创建服务端
 */

public class Receiver extends Thread {
    @Override
    public void run() {
        //创建DatagramSocket对象
        try {
            DatagramSocket ds = new DatagramSocket(8050);
            //将接收到的数据存储在字节数组
            byte[] buf = new byte[1024];
            //创建DatagramPacket对象
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            //一直处于监听窗口状态
            while (true) {
                System.out.println("接收端：准备接受数据...");
                ds.receive(dp);
                System.out.println("接收端：完成数据接收...");
                String data = new String(dp.getData(), 0, dp.getLength());
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                int length = dp.getLength();
                System.out.println("数据: " + data + " 地址: "+ ip + " 端口: "+ port + " 长度:" + length);
                if("exit".equals(data)) {
                    break;
                }
            }
            ds.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
