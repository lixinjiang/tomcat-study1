package cn.lxj.chapter3;

import cn.lxj.chapter3.connector.http.HttpRequest;
import cn.lxj.chapter3.connector.http.HttpResponse;

import java.io.IOException;

/**
 * StaticResourceProcessor
 * description TODO
 * create by lxj 2018/7/9
 **/
public class StaticResourceProcessor {

    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
