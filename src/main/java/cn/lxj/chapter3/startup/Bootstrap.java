package cn.lxj.chapter3.startup;

import cn.lxj.chapter3.connector.http.HttpConnector;

/**
 * Bootstrap
 * description 启动类
 * create by lxj 2018/7/6
 **/
public class Bootstrap {
    public static void main(String[] args) {
        HttpConnector httpConnector = new HttpConnector();
        httpConnector.start();
    }
}
