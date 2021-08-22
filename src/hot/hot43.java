package hot;

/**
 * @author wgl
 * @create 2021-08-19 18:40
 */
public class hot43 {
    public static void main(String[] args) {
        hot43 hot43 = new hot43();
        hot43.multiply("256", "3");
    }
    public String multiply(String num1, String num2) {
        String res = "";
        int len = num1.length() - 1;
        while (len >= 0) {
            String curLenAns = multiSingle(num2, num1.charAt(len));
            res = addStrings(curLenAns + "0", res);
            len--;
        }

        return res.substring(0, res.length() - 1);
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }

        ans.reverse();
        return ans.toString();
    }
    public String multiSingle(String num, char single) {
        int s = single - '0';
        // String s = Character.toString(single);
        int add = 0;
        int cur = 0;
        int len = num.length() - 1;
        StringBuffer ans = new StringBuffer();

        while (len >= 0) {
            int preAdd = add;
            add = ((num.charAt(len) - '0') * s + preAdd) / 10;
            cur = ((num.charAt(len) - '0') * s + preAdd) % 10;
            ans = ans.append(Integer.toString(cur));
            len--;
        }
        if (add != 0) {
            ans.append(Integer.toString(add));
        }
        return ans.reverse().toString();

    }
}
