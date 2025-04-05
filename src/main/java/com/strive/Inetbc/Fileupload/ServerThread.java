package com.strive.Inetbc.Fileupload;

import java.io.*;
import java.net.Socket;

/**
 * @parm
 *  服务端
 */

@SuppressWarnings("all")
public class ServerThread implements Runnable {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    int count = 1;

    @Override
    public void run() {
        // 创建一个文件夹
        File parentFile = new File("C:\\Users\\strive\\Desktop\\upload");
        // 判断 如果文件夹不存在
        if(!parentFile.exists()){
            // 创建这个文件夹
            parentFile.mkdirs();
        }
        String ip = socket.getInetAddress().getHostAddress();
        // 创建文件 把客户端的IP作为文件夹的名字 127.0.0.1(count)
        File file = new File(parentFile,ip+ "(" + count + ").png");
        if(file.exists()){
            file = new File(parentFile,ip+ "(" + (count++) + ").png");
        }
        try {
            // 获取客户端发送的数据 通过IO写入到上述文件中
            InputStream is = socket.getInputStream();
            // 创建一个输出流对象(FlieOutStream)流
            FileOutputStream fos = new FileOutputStream(file);

            byte[] buf = new byte[1024];
            int len = 0;
            // 读取到的数据在buf缓冲区中 len表示读取数据的长度
            while((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            // 服务器的输出流对象
            OutputStream os = socket.getOutputStream();
            os.write("文件上传成功".getBytes());

            fos.close();
            os.close();
            is.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
