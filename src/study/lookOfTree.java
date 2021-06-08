package study;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wgl
 * @create 2021-04-23 10:18
 * 遍历二叉树，并存在二位的数组（集合）中
 */
public class lookOfTree {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        List<List<Integer>> biglist = new ArrayList<>();
        // List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> list = new ArrayDeque<>();
        list.add(root);
        while (!list.isEmpty()) {
            int count = list.size();
            List<Integer> smallist = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode node = list.poll();
                smallist.add(node.val);
                if (node.left != null) {
                    list.add(node.left);
                }
                if (node.right != null) {
                    list.add(node.right);
                }
            }
            biglist.add(smallist);
        }
        return biglist;
    }
}

