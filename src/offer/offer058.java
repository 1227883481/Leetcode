package offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wgl
 * @create 2021-06-05 11:00
 */
public class offer058 {
    public static void main(String[] args) {
        offer058 offer058 = new offer058();
//        offer058.reverseWords(" hello   world!     ");
        offer058.reverseLeftWords("abcdefg", 2);
    }
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        // Deque<StringBuilder> deq = new ArrayDeque<>();
        String[] arr = s.split(" ");
        int len = arr.length;
        // str.append(arr[len - 1].trim());
        for (int i = len - 1; i >= 0 ; i--) {
            if (!arr[i].equals(" ")) {
                if (i == len - 1) {
                    str.append(arr[i].trim());
                } else {
                    str.append(" ");
                    str.append(arr[i].trim());
                }
            }
        }
        int i = 0;
        return str.toString();
    }

    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        char[] arr = s.toCharArray();
        char[] arrn = Arrays.copyOf(arr, n);
        arr = Arrays.copyOfRange(arr, n, s.length());
        System.arraycopy(arrn, 0, arr, s.length() - n, n);
        return Arrays.toString(arr);
    }
}
