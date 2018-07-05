package cn.lxj.chapter1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * HttpResponse
 * description：
 * <p>
 * HTTP Response = Status-Line
 * (( general-header | response-header | entity-header ) CRLF)
 * CRLF
 * [ message-body ]
 * Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase CRLF
 * <p>
 * create by lxj 2018/7/3
 **/
public class Response {
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sentStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            //System.out.println("response,request.getUri():" + request.getUri());
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            //System.out.println("filepath：" + file.getPath());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
//                int i = fis.available();
//                byte[] b = new byte[i];
//                fis.read(b);
//                outputStream.write(b);
            } else {
                String errorMessage = "HTTP/1.1 404 File not found\r\n" +
                        "Content-Type: text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outputStream.write(errorMessage.getBytes());
            }
        } catch (IOException e) {
            // thrown if cannot instantiate a File object
            System.out.println(e.toString());
        } finally {
            if (fis != null) fis.close();
        }
    }
}