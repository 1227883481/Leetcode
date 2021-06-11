package hot;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author wgl
 * @create 2021-06-09 11:04
 */
public class test1 {
    public static void main(String[] args) {
        test1 test1 = new test1();
//        Person man = new Man();
        Man man = new Man();
        man.eat();
        Goshool goshool = new Goshool();
        goshool.study(man);
    }
}
class Person {
    public void eat() {
        System.out.println("eat方法");
    }
}
class Man extends Person{
    public void play() {
        System.out.println("man特有方法");
    }
}
class Goshool {
    public void study(Person p) {
        p.eat();
    }
}