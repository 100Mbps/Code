package item09;

import java.io.*;

/**
 * 9: Prefer try-with-resources to try-finally
 *
 * @author hanrongjie
 * @date 2020/9/14
 * @since jdk 1.7
 */
public class Main {

    public static void main(String[] args) {

    }

    /**
     * try-finally is ugly when used with more than one resource!
     */
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[16];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }


}

