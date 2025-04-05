package com.strive.Inetbc.Fileupload;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @parm
 *  客户端
 */

@SuppressWarnings("all")
public class FileClient {
    public static void main(String[] args) throws IOException {
        // 创建一个发送数据的Socket对象
        Socket socket = new Socket("127.0.0.1",8877);
        // 用户在控制输入一个要上传的文件路径，客户端提交数据给服务器
        System.out.println("请输入你要上传的文件路径：");
        Scanner input = new Scanner(System.in);
        String fileName = input.nextLine();
        // 获取客户端的输出流对象
        OutputStream out = socket.getOutputStream();
        // 判断文件是否存在 是否为空文件
        if(!fileName.isEmpty()) {
            // 路径存在
            FileInputStream fis = new FileInputStream(fileName);
            // 将数据写出到out对象中
            // 定义一个字节数组
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                out.write(buf, 0, len); // 客户端发送数据
            }
        } else {
            System.out.println("你的路径不存在！");
        }

        // 客户端接收服务端的数据
        InputStream in = socket.getInputStream();
        byte[] msg = new byte[1024];
        in.read(msg);
        System.out.println(new String(msg,0,msg.length));

        socket.close();
        out.close();
        in.close();
    }
}
