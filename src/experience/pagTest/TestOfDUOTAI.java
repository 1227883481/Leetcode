package experience.pagTest;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author wgl
 * @create 2021-09-06 22:07
 * 测试多态
 */
public class TestOfDUOTAI {
    public static void main(String[] args) {
        Father p = new Son(5);
        Son p1 = (Son) p;
        p1.staticMethod();
        p.eat();
        System.out.println(p.age);
        Object str = new String("shide");
        Object obj = new Father();
        System.out.println(obj);

        Father father = new Father();

        //list.add
        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        list.add("2");
        list.add(1,"3");
        System.out.println(list);

        String s = new String("1,2,3,4,5");
        System.out.println(s);
        String[] split = s.split(",",3);
        for (String spl : split) {
            System.out.print(spl);
            System.out.print(" ");
        }
    }
}
class Father {
    public int age = 50;
    public Father(int i) {
        this.age = i;
    }
    public static void staticMethod() {
        System.out.println("父亲静态类");
    }
    public String name = "Tom";

    public Father() {

    }

    public void eat() {
        System.out.println("father");
    }
    private void work () {
        System.out.println("父类私有方法工作");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Father father = (Father) o;
        return age == father.age && Objects.equals(name, father.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    public String toString() {
        return "Father{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class Son extends Father {
//    public static void staticMethod() {
//        System.out.println("儿子静态类");
//    }
    public int age = 10;
    public String name = "lim";

    public Son(int i) {
        super(i);
    }

    public Son() {

    }

    public void eat() {
        System.out.println("son");
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}