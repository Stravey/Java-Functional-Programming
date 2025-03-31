package com.strive.Inetbc.ThreadTCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务类
 */

public class TCPServer {
    private static final int PORT = 8099;

    public void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        while (true) {
            // 与客户端建立了连接
            Socket socket = serverSocket.accept();
            // 匿名内部类 传递一个Runnable接口类型的对象
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 给客户端传数据
                    try {
                        OutputStream os = socket.getOutputStream();
                        System.out.println("开始与客户端通信");
                        os.write("您好！客户端".getBytes());
                        System.out.println("结束与客户端通信");
                        os.close();
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start(); // 创建一个线程并开启这个线程
        }
    }
}
