package com.strive.Inetbc.Inet;

import java.io.IOException;
import java.net.*;

/**
 * 发送数据端
 */
@SuppressWarnings("all")
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket m = new DatagramSocket(8095);

        String str = "hello";
        byte[] buf = str.getBytes();

        InetAddress address = InetAddress.getByName("localhost");

        DatagramPacket n = new DatagramPacket(buf, buf.length,address,8095);

        System.out.println("发送端：开始发送数据...");
        m.send(n);
        System.out.println("发送端：发送数据完成。。。");

        m.close();
    }
}
