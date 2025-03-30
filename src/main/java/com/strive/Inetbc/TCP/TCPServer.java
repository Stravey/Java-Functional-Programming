package com.strive.Inetbc.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端
 */

public class TCPServer {
    private static final int PORT = 8050;

    //定义一个监听方法 处理客户端发送的请求
    public void listen() throws IOException {
        // 创建一个ServerSocket对象 同时指定坚听的端口 供客户端连接使用
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("服务端: 正在监听数据...");
        // 如果没有客户端连接 处于阻塞状态
        Socket socket = serverSocket.accept(); // 服务端对象
        System.out.println("服务端: 接收到数据...");
        // 通过socket对象读取数据
        OutputStream os = socket.getOutputStream(); // 客户端的输出就是服务端的输入
        // 服务端还可以发送数据给客户端
        String data = new String("您好！");
        // 向客户端写出数据
        os.write(data.getBytes());
        // 关闭流对象
        os.close();
        // 关闭socket关闭
        socket.close();
        serverSocket.close();
    }
}
