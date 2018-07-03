package cn.lxi.chapter1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * HttpServer
 * description TODO
 * create by lxj 2018/7/3
 **/
public class HttpServer {
    /**
     * WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the working
     * directory.
     * The working directory is the location in the file system
     * from where the java command was invoked.
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    // shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    // the shutdown command received
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();
    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);// 正常退出
        }

        // Loop waiting for a request
        while (!shutdown) {
            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

                // create Request object and parse
                Request request = new Request(inputStream);
                request.parse();

                // create Response object
                Response response = new Response(outputStream);
                response.setRequest(request);
                response.sentStaticResource();

                // Close the socket
                socket.close();

                //check if the previous URI is a shutdown command
                // //System.out.println("request.getUri()：" + request.getUri());
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);//退出轮询
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}