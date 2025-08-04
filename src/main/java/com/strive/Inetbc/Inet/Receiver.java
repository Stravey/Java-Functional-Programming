package com.strive.Inetbc.Inet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收数据端
 */
@SuppressWarnings("all")

public class Receiver {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，分配一个端口，监听8095端口
        DatagramSocket ds = new DatagramSocket(8095);

        byte[] buf = new byte[1024];
        //定义一个DatagramPacket对象
        DatagramPacket dp = new DatagramPacket(buf, buf.length);

        System.out.println("接收端：等待接收数据...");

        // 调用DatagramSocket类的receive方法来接收数据
        ds.receive(dp);
        System.out.println("接收端：数据接收完毕...");

        String data = new String(dp.getData(), 0, dp.getLength());
        System.out.println("接收数据内容" + " " + data);
        String server = dp.getAddress().getHostAddress() + ":" + dp.getPort();
        System.out.println(server);

        ds.close();
    }
}
