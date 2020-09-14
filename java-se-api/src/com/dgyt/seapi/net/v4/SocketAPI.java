package com.dgyt.seapi.net.v4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.concurrent.*;

public class SocketAPI {
    private final static String CONTENT = "Hello World";

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(20);
        Executor executor = new ThreadPoolExecutor(4, 8, 100, TimeUnit.SECONDS, queue);
        try (ServerSocket server = new ServerSocket(8080)) {
            while (true) {
                Socket client = server.accept();
                executor.execute(SocketRunalbe.create(client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
private static class SocketRunalbe implements Runnable {

    private final Socket socket;

    private SocketRunalbe(Socket socket) {
        Objects.requireNonNull(socket);
        this.socket = socket;
    }

    public static SocketRunalbe create(Socket socket) {
        return new SocketRunalbe(socket);
    }

    @Override
    public void run() {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            os.write(CONTENT.getBytes());
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
    }
}


}
