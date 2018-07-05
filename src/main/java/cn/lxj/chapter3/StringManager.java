package cn.lxj.chapter3;

import java.util.Hashtable;

/**
 * StringManager
 * description TODO
 * create by lxj 2018/7/5
 **/
public class StringManager {
    private static Hashtable managers = new Hashtable();

    private static String packageName;

    public StringManager(String packageName) {
        this.packageName = packageName;
    }

    public synchronized static StringManager getManager(String packageName) {
        StringManager mgr = (StringManager) managers.get(packageName);
        if (mgr == null) {
            mgr = new StringManager(packageName);
            managers.put(packageName, mgr);
        }
        return mgr;
    }
}
