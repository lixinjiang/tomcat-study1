package cn.lxj.chapter1;

import java.io.IOException;
import java.io.InputStream;

/**
 * Request
 * description 创建自定义Request类
 * create by lxj 2018/7/3
 **/
public class Request {
    private InputStream inputStream;
    private String uri;

    public Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public void parse() {
        // Read a set of characters from the socket
        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];

        try {
            i = inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
//            GET / HTTP/1.1
//            Host: localhost:8080
//            Connection: keep-alive
//            User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36
//            Upgrade-Insecure-Requests: 1
//            Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8
//            Accept-Encoding: gzip, deflate, br
//            Accept-Language: zh-CN,zh;q=0.8
//            Cookie: Idea-13e27249=6761e3ad-9f44-4cf1-940c-429a5b8dcb14
        System.out.println(request.toString());
        uri = parseUri(request.toString());
    }

    private String parseUri(String requestStr) {
        int index1, index2;
        index1 = requestStr.indexOf(" ");
        //System.out.println("index1：" + index1);
        if (index1 != -1) {
            index2 = requestStr.indexOf(" ", index1 + 1);
            //System.out.println("index2:" + index2);
            if (index2 > index1) {
                return requestStr.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}