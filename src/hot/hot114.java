package hot;

/**
 * @author wgl
 * @create 2021-06-20 17:11
 */

import java.util.ArrayDeque;
import java.util.Deque;


//Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class hot114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
        }
        deque.push(root);
        // TreeNode head = root;
        TreeNode index = root;
        TreeNode cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            if (cur.right != null) {
                deque.push(cur.right);
            }
            if (cur.left != null) {
                deque.push(cur.left);
            }
            index.left = null;
            index.right = cur;
            index = index.right;
        }
    }
}