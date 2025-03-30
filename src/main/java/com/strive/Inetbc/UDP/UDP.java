package com.strive.Inetbc.UDP;

public class UDP {
    public static void main(String[] args) {
        //创建接收端线程
        new Receiver().start();
        new Sender().start();
    }
}
