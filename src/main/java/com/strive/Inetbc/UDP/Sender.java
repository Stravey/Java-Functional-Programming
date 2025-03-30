package com.strive.Inetbc.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 创建客户端
 */

public class Sender extends Thread {
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
