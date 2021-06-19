package hot;

/**
 * @author wgl
 * @create 2021-06-18 16:41
 */
public class hot58 {
    public static void main(String[] args) {
        hot58 hot58 = new hot58();
        hot58.lengthOfLastWord(" a");
    }
    public int lengthOfLastWord(String s) {
        int len = s.length();
        s.trim();
        if (s.length() == len) {
            if (s.equals("")) {
                return 0;
            }
            if (s.charAt(0) == ' ') {
                return 0;
            }
        }
        String[] str = s.split(" ");
        return str[str.length - 1].length();
    }
}
