package com.strive.Inetbc.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 创建接收端
 */
class Receiver extends Thread {
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

/**
 * 创建发送端
 */
class Sender extends Thread {
    @Override
    public void run() {
        try {
            //创建DatagramSocket对象
            DatagramSocket ds = new DatagramSocket(8010);

            //创建一个Scanner对象
            Scanner input = new Scanner(System.in);
            //获取IP地址
            InetAddress address = InetAddress.getByName("127.0.0.1");
            while (true) {
                String content = input.nextLine();
                byte[] buf = content.getBytes();
                //创建DatagramPacket对象
                DatagramPacket dp = new DatagramPacket(buf, buf.length,address,8050);
                System.out.println("发送端：准备发送数据...");
                ds.send(dp);
                System.out.println("发送端：发送数据完成...");
                if("exit".equals(content)){
                    break;
                }
            }
            ds.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class UDP {
    public static void main(String[] args) {
        //创建接收端线程
        new Receiver().start();
        new Sender().start();
    }
}
