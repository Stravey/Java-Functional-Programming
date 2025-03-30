package com.strive.Inetbc.TCP;

import java.io.IOException;

/**
 * 客户端程序
 */

public class Client {
    public static void main(String[] args) throws IOException {
        new TCPClient().connect();
    }
}
