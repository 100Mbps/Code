package com.dgyt.seapi.net.v2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 每个客户端新建一个线程
 * @author hanrongjie
 */
public class SocketAPI {
    public static void main(String[] args) throws IOException {
        String content = "hello world";

        try (ServerSocket socket = new ServerSocket(8080)) {
            while (true) {
                final Socket client = socket.accept();
                new Thread(() -> {
                    InputStream is = null;
                    OutputStream os = null;
                    try {
                        is = client.getInputStream();
                        os = client.getOutputStream();
                        os.write(content.getBytes());
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    } finally {
                        try {
                            if (is != null) {
                                is.close();
                            }
                            if (os != null) {
                                os.close();
                            }
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                }).start();
            }
        }
    }
}