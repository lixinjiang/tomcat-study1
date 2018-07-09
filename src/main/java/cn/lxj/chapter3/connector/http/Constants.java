package cn.lxj.chapter3.connector.http;

import java.io.File;

/**
 * Constants
 * description TODO
 * create by lxj 2018/7/6
 **/
public final class Constants {
    public static final String WEB_ROOT =
            System.getProperty("user.dir") + File.separator  + "webroot";
    // TODO 不同包下要做更改
    public static final String Package = "cn.lxj.chapter3.connector.http";
    public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
    public static final int PROCESSOR_IDLE = 0;
    public static final int PROCESSOR_ACTIVE = 1;
}
