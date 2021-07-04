package labuladong;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgl
 * @create 2021-07-04 22:19
 */
public class lc51 {
    public static void main(String[] args) {
        lc51 lc51 = new lc51();
        lc51.solveNQueens(4);
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        int[][] note = new int[n][n];
        dfs(n, list, list1, note, 0);
        return list;
    }
    public void dfs(int n, List<List<String>> list, List<String> list1, int[][] note, int depth) {
        if (depth >= n) {
            List<String> temp = new ArrayList<>(list1);
            list.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (note[depth][i] == 1) {
                continue;
            }
            //创造一个
            list1.add(getString(i, n));
            int[][] newNote = getNote(note, depth, i);
            dfs(n, list, list1, newNote, depth + 1);
            list1.remove(list1.size() - 1);
        }
    }
    public String getString(int cur, int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cur - 1; i++) {
            str.append(".");
        }
        str.append("Q");
        for (int i = cur; i < n; i++) {
            str.append(".");
        }
        return str.toString();
    }
    public int[][] getNote(int[][] note, int depth, int cur) {
        int[][] newNote = new int[note.length][note[0].length];
        for (int i = 0; i < note.length; i++) {
            for (int j = 0; j < note[0].length; j++) {
                if (note[i][j] == 1 || i - depth == j - cur || i == depth || j == cur) {
                    newNote[i][j] = 1;
                }
            }
        }
        return newNote;
    }
}
