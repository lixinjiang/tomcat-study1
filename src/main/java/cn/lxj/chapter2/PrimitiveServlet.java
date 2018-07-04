package cn.lxj.chapter2;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * PrimitiveServlet
 * description 原始的servlet
 * create by lxj 2018/7/3
 **/
public class PrimitiveServlet implements Servlet{
    /**
     * 初始化--生命周期，用来写仅仅只要运行一次的初始化代码，例如加载数据库驱动，值初始化等等，在其他情况下，这个方法留空
     * @param servletConfig
     * @throws ServletException
     */
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    /**
     * 处理类--生命周期，在servlet的生命周期中，service方法将会被调用多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out = servletResponse.getWriter();
        out.println("Hello ,Roses are red.");
        out.print("Violets are blue.");
    }

    /**
     * 销毁方法--生命周期，当从服务器中移除一个servlet实例的时候，将调用destroy方法
     * 一般发生在servlet容器正在被关闭或servlet容器需要一些空闲内存的时候
     * 仅仅在所有的servlet线程的service方法已经退出或者超时淘汰的时候，这个方法才会被调用，
     * 当servlet容器调用完destroy方法之后，在同一个servlet里边将不会再调用service方法。
     * destroy方法提供了一个机会来清理任何已经被占用的资源，例如内存，文件句柄和线程，并确保任何持久化状态和servlet的内存当前状态是同步的
     */
    public void destroy() {
        System.out.println("destory");
    }

    /**
     * 获取servlet信息
     * @return
     */
    public String getServletInfo() {
        return null;
    }

    /**
     * servlet的配置
     * @return
     */
    public ServletConfig getServletConfig() {
        return null;
    }
}