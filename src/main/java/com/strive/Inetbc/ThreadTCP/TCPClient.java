package com.strive.Inetbc.ThreadTCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端
 */

public class TCPClient {

    private static final int PORT = 8060;

    public void connect() throws IOException {
        // 创建一个Socket对象:指定连接的服务器IP地址、端口号
        Socket socket = new Socket(InetAddress.getLocalHost(), PORT);
        InputStream is = socket.getInputStream(); //获取服务器发送给客户端的流对象
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        //将缓冲区的数据转换成字符串输出
        System.out.println(new String(buf, 0, len));
        is.close();
        socket.close(); // 释放资源
    }

}
