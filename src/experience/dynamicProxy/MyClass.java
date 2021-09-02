package experience.dynamicProxy;

/**
 * @author wgl
 * @create 2021-09-02 11:04
 */
public class MyClass implements MyInterface, MyInterface2 {
    @Override
    public void eat() {
        System.out.println("eating");
    }

    @Override
    public void run(int time) {
        System.out.printf("跑步时间为%d", time);
        System.out.println();
    }

    @Override
    public String study(){
        return "数学";
    }

    @Override
    public void writeCode() {
        System.out.println("敲代码");
    }
}
