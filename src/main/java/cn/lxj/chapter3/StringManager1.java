package cn.lxj.chapter3;

import java.util.Hashtable;

/**
 * StringManager1
 * description TODO
 * create by lxj 2018/7/5
 **/
public class StringManager1 {
    private static Hashtable managers = new Hashtable();

    private static String packageName;

    public StringManager1(String packageName) {
        this.packageName = packageName;
    }

    public synchronized static StringManager1 getManager(String packageName) {
        StringManager1 mgr = (StringManager1) managers.get(packageName);
        if (mgr == null) {
            mgr = new StringManager1(packageName);
            managers.put(packageName, mgr);
        }
        return mgr;
    }
}
