package com.dgyt.seapi.net.v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hanrongjie
 * @date 2020/9/14
 */
public class SocketAPI {
    public static void main(String[] args) throws IOException {
        String content = "hello world";
        try(ServerSocket socket  = new ServerSocket(8080)){
             Socket client =   socket.accept();
             try(InputStream is = client.getInputStream();
             OutputStream os = client.getOutputStream()){
                 os.write(content.getBytes());
             }
        }
    }
}
