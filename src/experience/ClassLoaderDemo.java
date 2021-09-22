package experience;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.util.HashMap;
import java.util.Random;

/**
 * @author wgl
 * @create 2021-08-18 21:47
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {

        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());

        new ClassLoader(){

        };
        ClassLoader classLoader = new ClassLoader(){
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }
        };
    }
}
