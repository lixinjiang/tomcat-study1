package cn.lxi.chapter1;

import java.io.*;
import java.net.Socket;

/**
 * chapter1
 * description socket
 * create by lxj 2018/7/2
 **/
public class Socket1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        boolean autoFlush = true;
        //socket写出流
        PrintWriter out = new PrintWriter(socket.getOutputStream(), autoFlush);
        //socket读取流
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //send an HTTP request to the web server
        out.print("GET /index.jsp HTTP/1.1");
        out.println("Host: localhost:8080");
        out.println("Connection: Close");
        out.println();
        // read the response
        boolean loop = true;
        StringBuffer sb = new StringBuffer(8096);//缓冲区大小
        while (loop) {
            if (in.ready()) {
                int i = 0;
                while (i != -1) {
                    i = in.read();
                    sb.append((char) i);
                }
                loop = false;
            }
            Thread.currentThread().sleep(50);
        }
        // display the response to the out console
        System.out.println(sb.toString());
        socket.close();
    }
}