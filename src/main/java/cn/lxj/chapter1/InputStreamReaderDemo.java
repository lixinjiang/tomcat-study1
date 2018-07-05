package cn.lxj.chapter1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * InputStreamReaderDemo
 * description inputstream.ready()方法测试 Demo
 * create by lxj 2018/7/2
 **/
public class InputStreamReaderDemo {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        boolean bool = false;
        int i;
        char c;

        try {
            // new input stream reader is created
            fis = new FileInputStream("D:/123.xml");
            isr = new InputStreamReader(fis);

            // reads into the char buffer
            while ((i = isr.read()) != -1) {
                // converts int to char
                c = (char) i;

                // prints the character
                System.out.println("Character read: " + c);

                // true if the next read is guaranteed
                bool = isr.ready();

                // prints
                System.out.println("Ready to read: " + bool);
            }
        } catch (Exception e) {

            // print error
            e.printStackTrace();
        } finally {

            // closes the stream and releases resources associated
            if (fis != null)
                fis.close();
            if (isr != null)
                isr.close();
        }
    }
}
