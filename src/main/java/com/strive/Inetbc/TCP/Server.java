package com.strive.Inetbc.TCP;

import java.io.IOException;

/**
 * 服务端程序
 */

public class Server {
    public static void main(String[] args) throws IOException {
        new TCPServer().listen();
    }
}
