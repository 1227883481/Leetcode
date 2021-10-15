package hot;

import java.util.Arrays;

/**
 * @author wgl
 * @create 2021-10-15 15:08
 */
public class KMP {
    public static void main(String[] args) {
        String s1 = new String("abcabaaaabaabcac");
        String s2 = new String("abaabcac");
        KMP kmp = new KMP();
        int res = kmp.kmp(s1.toCharArray(), s2.toCharArray());
        System.out.println(res);
        System.out.println(s1.charAt(res));
    }

    /**
     * kmp算法
     * @param s1 要匹配的文本字符串
     * @param s2 输入的短字符串
     */
    public int kmp(char[] s1, char[] s2) {
        int[] next = calculateNext(s2);
        int i = 0, j = 0;
        while (j < s2.length) {
            if (i >= s1.length) {
                return -1;
            }
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        return i - j;
    }

    /**
     * 计算next数组
     * @param s1
     * @return
     */
    public int[] calculateNext(char[] s1) {
        int[] res = new int[s1.length];
        res[0] = 0;
        for (int index = 1; index < s1.length; index++) {
            int compare = res[index - 1];
           while (true) {
               if (compare == 0) {
                   if (s1[compare] == s1[index]) {
                       res[index] = 1;
                   } else {
                       res[index] = 0;
                   }
                   break;
               }

               if (s1[compare] == s1[index]) {
                   res[index] = compare + 1;
                   break;
               } else {
                   compare = res[compare - 1];
               }
           }
        }
        return res;
    }
}
