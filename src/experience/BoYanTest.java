package experience;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.AbstractSet;
import java.util.HashSet;

/**
 * @author wgl
 * @create 2021-09-18 10:42
 */
public class BoYanTest {

    public static void main(String[] args) {
        String str = new String("abc");
        strProcess(str);
        System.out.println(str);


    }
    public static int Test111(int i) {
        int res = 0;
        switch (i) {
            case 1 :
                res = res + i;
            case 2 :
                res = res + i *2;
            case 3 :
                res = res + i * 3;
        }
        return res;
    }
    public static String strProcess(String str) {
//        str = "aaa";
        System.out.println(str.toUpperCase());
        return str;
    }


}
