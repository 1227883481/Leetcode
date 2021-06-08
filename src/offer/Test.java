package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        test.serialize(node1);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int deep = deep(root);
        deque.add(root);
        double count = 0;
        for (int i = 0; i < deep; i++) {
            count = Math.pow(2, i);
            for (int j = 0; j < count; j++) {
                TreeNode cur = deque.poll();
                if (cur == null) {
                    list.add(null);
                    if (i != deep - 1) {
                        deque.offer(null);
                        deque.offer(null);
                    }

                } else {
                    list.add(cur.val);
                    if (i != deep - 1) {
                        deque.offer(cur.left);
                        deque.offer(cur.right);
                    }
                }
            }
        }
        return list.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") {
            return null;
        }
        String[] str = data.substring(1, data.length() - 2).split(",");
        Integer[] arr = new Integer[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("null")) {
                arr[i] = null;
            } else {
                arr[i] = Integer.parseInt(str[i]);
            }
        }
        TreeNode root = new TreeNode(arr[0]);
        binaryTree(arr, 0, root);
        return root;
    }

    public void binaryTree (Integer[] arr, int i, TreeNode node) {
        if (2 * i + 1 < arr.length) {
            TreeNode left;
            if (arr[2*i + 1] == null) {
                left = null;
            } else {
                left = new TreeNode(2 * i + 1);
            }
            node.left = left;
            binaryTree(arr, 2 * i + 1, left);
        }
        if (2 * i + 2 < arr.length) {
            TreeNode right;
            if (arr[2*i + 2] == null) {
                right = null;
            } else {
                right = new TreeNode(2 * i + 2);
            }
            node.right = right;
            binaryTree(arr, 2 * i + 2, right);
        }
    }

    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deep(root.left), deep(root.right)) + 1;
    }
}

