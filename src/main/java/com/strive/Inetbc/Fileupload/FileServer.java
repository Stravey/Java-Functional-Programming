package com.strive.Inetbc.Fileupload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("all")
public class FileServer {
    public static void main(String[] args) throws IOException {
        // 服务端就可以监听8877端口 客户端就可以通过8877端口向服务端发送数据
        ServerSocket serverSocket = new ServerSocket(8877);
        while (true) {
            System.out.println("服务器:开启...");
            // 开启监听
            Socket socket = serverSocket.accept();
            System.out.println("服务器:接收到数据！");
            // 交给线程操作
            new Thread(new ServerThread(socket)).start();
        }
    }
}
