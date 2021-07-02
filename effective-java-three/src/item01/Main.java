package item01;

/**
 * Item 1: Consider static factory methods instead of constructors
 * 静态方法替代构造器。
 *
 * @see java.util.ServiceLoader
 * @author hanrongjie
 * @date 2020/9/11
 */
public class Main {

    /**
     *  see java.lang.Integer.IntegerCache
     * @param args args
     */
    public static void main(String[] args) {
        //eg.  high 取决于 -D java.lang.Integer.IntegerCache.high=2048 配置
        int a = Integer.parseInt("10000");
        int b = Integer.parseInt("10000");
        //true
        System.out.println(a == b);
        int a0  = Integer.parseInt("10000");
        int b0 = Integer.parseInt("10000");
        //false
        System.out.println(a0 == b0);
    }
}

