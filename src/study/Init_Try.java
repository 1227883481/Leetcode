package study;

/**
 * @author wgl
 * @create 2021-05-08 22:31
 */
public class Init_Try {
    static int b = 10;

    static {
        b = 200;
    }
    static int c = 10;

    public static void main(String[] args) {
        System.out.println(b);
    }

}
