package experience.huawei;

import com.sun.prism.shader.Solid_RadialGradient_REFLECT_AlphaTest_Loader;

import java.util.*;

/**
 * @author wgl
 * @create 2021-09-08 18:55
 */
public class helpTest {
//    int timeCount = 0;
    public static void main(String[] args) {
        String obj = new String(); //目标项目
//        Map<String, List<Integer>> time = new HashMap<>();    //记录时间
        Map<String, List<String>> depend = new HashMap<>(); //记录依赖
        Scanner scan = new Scanner(System.in);
//        if (scan.hasNext()) {
//            obj = scan.nextLine();
//        }
        while (scan.hasNextLine()) {
            System.out.println("##");
            String scanString = scan.nextLine();
            System.out.println(scanString);
            System.out.println("*********");
//            if (scanString.equals("cc")) {
            if (scanString == null|| scanString.length() == 0 || scanString.equals(" ")) {
                break;
            }

        }
        StringBuilder
        Map<String, Integer> flag = new HashMap<>();
        helpTest helpTest = new helpTest();
        int res = helpTest.help(obj, depend, flag);
//        System.out.println(res);
    }

    public int help(String obj, Map<String, List<String>> depend, Map<String, Integer> flag) {
        if (flag.getOrDefault(obj, 0) == 1) {
            return -1;
        }
        if (depend.getOrDefault(obj, new ArrayList<>()).size() == 0) {
            return -1;
        }
        if (flag.getOrDefault(obj, 0) == 0) {
            flag.put(obj, 1);
            List<String> list = depend.getOrDefault(obj, new ArrayList<>());
            int timeCount = 0;
            if (list.size() > 0) {
                timeCount =  Integer.parseInt(list.get(0));
            }
            int sum = 0; //实现每一个依赖需要的时间
            for (int i = 1; i < list.size(); i++) {
                int curTime = help(list.get(i), depend, flag);
                if (curTime == -1) {
                    return -1;
                } else {
                    sum =sum + curTime;
                }
            }
            return sum + timeCount;
        }
        return 0;
    }
}
