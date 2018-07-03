package cn.lxj.chapter2;

import java.io.IOException;

/**
 * StaticResourceProcessor
 * description TODO
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
