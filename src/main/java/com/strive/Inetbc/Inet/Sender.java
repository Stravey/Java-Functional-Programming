package com.strive.Inetbc.Inet;

import java.io.IOException;
import java.net.*;

/**
 * 发送数据端
 */
@SuppressWarnings("all")
public class Sender {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象，作为对象的载体使用
        DatagramSocket ds = new DatagramSocket(8089);

        //创建一个字节数组:字节数组类放的是要发送给数据端的数据
        String str = "你好，接收端";
        byte[] buf = str.getBytes();

        InetAddress address = InetAddress.getByName("localhost");

        //创建一个数据发送的包dp，数据包的内容：数据、接收端(ip，port)
        //端口号需要和接收端坚挺的端口保持一致
        DatagramPacket dp = new DatagramPacket(buf, buf.length,address,8095);

        System.out.println("发送端：开始发送数据...");
        ds.send(dp);//发送数据给接收端
        System.out.println("发送端：发送数据完成...");

        //释放资源
        ds.close();
    }
}
