package study;

/**
 * @author wgl
 * @create 2021-05-12 11:09
 */
class Solution {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'a', 'b'}, { 'c', 'd'}
        };
        String word = "cdba";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int[][] flag = new int[board.length][board[0].length];
                if (find(board, flag, row, col, -1, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean find(char[][] board, int[][] flag, int i, int j, int index, String word) {
        index++;
        if (index >= word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (flag[i][j] == 1) {
            return false;
        }
        flag[i][j] = 1;
        if (board[i][j] != word.charAt(index)) {
            flag[i][j] = 0;
            return false;
        }
        if (find(board, flag, i-1, j, index, word)) {
            return true;
        } else if (find(board, flag, i, j-1, index, word)) {
            return true;
        } else if (find(board, flag, i+1, j, index, word)) {
            return true;
        } else if (find(board, flag, i, j+1, index, word)) {
            return true;
        } else {
            flag[i][j] = 0;
            return false;
        }
    }
}