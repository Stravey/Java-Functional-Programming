package com.strive.Inetbc.ThreadTCP;

import java.io.IOException;

public class Client1 {
    public static void main(String[] args) throws IOException {
        new TCPClient().connect();
    }
}
