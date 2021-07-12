package hot;

import java.util.HashMap;

/**
 * @author wgl
 * @create 2021-07-11 18:22
 */
public class hot236 {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int temp = dfs(root, p, q);
        return res;
    }
    //一个方法，如果包含一个，返回值1，包含两个，返回值2，其他0,包括本身
    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, p, q);
        if (left == 3) {
            return 3;
        }
        int right = dfs(root.right, p, q);
        if (right == 3) {
            return 3;
        }
        int cur = 0;
        if (root.val == p.val || root.val == q.val) {
            cur = 1;
        }
        int count = left + right + cur;
        if (count == 2) {
            res = root;
            return 3;
        }
        return count;
        HashMap
    }
}
