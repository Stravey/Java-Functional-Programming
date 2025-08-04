package com.strive.Inetbc.Inet;

import java.io.IOException;
import java.net.InetAddress;

public class Test {
    public static void main(String[] args) throws IOException {
        //创建一个表示本地主机InetAddress的对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        //本机名称：LAPTOP-AF6V3NAN
        System.out.println(inetAddress.getHostName());
        //获取本地的ip地址，字符串类型：192.168.133.1
        System.out.println(inetAddress.getHostAddress());

        InetAddress nameA = InetAddress.getByName("www.baidu.com");
        //根据目标主机域名ip地址：110.242.70.57
        System.out.println(nameA.getHostAddress());

        InetAddress nameB = InetAddress.getByName("www.mi.com");
        //根据目标主机域名ip地址：139.170.157.10
        System.out.println(nameB.getHostAddress());

        System.out.println(inetAddress.isReachable(3000));
    }
}
