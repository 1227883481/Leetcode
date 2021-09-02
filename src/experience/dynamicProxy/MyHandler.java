package experience.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wgl
 * @create 2021-09-02 11:06
 */
public class MyHandler implements InvocationHandler {

    Object target; //被代理类的对象，传入的参数，可以使任何类
    public MyHandler(Object obj) {
        target = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        beforeMethod();
        Object result = method.invoke(target, args);
        afterMethod();
        return result;
    }

    public void beforeMethod() {
        System.out.println("做事情之前洗手");
    }
    public void afterMethod() {
        System.out.println("做事情之后喝水");
    }


}
