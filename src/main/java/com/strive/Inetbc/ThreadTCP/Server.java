package com.strive.Inetbc.ThreadTCP;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        new TCPServer().listen();
    }
}
