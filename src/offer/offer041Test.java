package offer;

/**
 * @author wgl
 * @create 2021-06-08 10:46
 */
public class offer041Test {
    public static void main(String[] args) {
        offer041Test offer041 = new offer041Test();
        offer041.method6(new test() {
            @Override
            public int method2(int x, int y) {
                return 0;
            }
        });
        offer041.method6((x, y) -> (x - y));
    }
    public void method6(test t) {
//        System.out.println("111");
        System.out.println(t.method2(1, 2));
    }
}

interface test {
//    void method1();
    int method2(int x, int y);
    default void method3() {
        System.out.println("2222");
    }

}


