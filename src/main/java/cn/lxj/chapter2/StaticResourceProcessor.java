package cn.lxj.chapter2;

import java.io.IOException;

/**
 * StaticResourceProcessor
 * description 静态资源处理类
 * create by lxj 2018/7/3
 **/
public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
