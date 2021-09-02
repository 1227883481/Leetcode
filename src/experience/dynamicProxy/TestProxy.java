package experience.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author wgl
 * @create 2021-09-02 11:13
 */
public class TestProxy {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        ClassLoader classLoader = myClass.getClass().getClassLoader();
        Class<?>[] interfaces = myClass.getClass().getInterfaces();
        MyHandler myHandler = new MyHandler(myClass);

        MyInterface o = (MyInterface) Proxy.newProxyInstance(classLoader, interfaces, myHandler);
        System.out.println(o.getClass());

        System.out.println("***************");
        o.eat();
        System.out.println("***************");
        o.run(10);
        System.out.println("***************");
        System.out.println(o.study());
        System.out.println("****************");

        System.out.println(myClass.getClass());
    }
}
