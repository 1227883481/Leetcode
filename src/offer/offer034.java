package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgl
 * @create 2021-05-16 20:54
 */
public class offer034 {
    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node55 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node5.right = node8;
        node8.left = node13;
        node8.right = node44;
        node44.left = node55;
        node44.right = node1;


        offer034 offer034 = new offer034();
        offer034.pathSum(node5, 22);
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        look(root, 0, target, res, list);
        return res;
    }
    public void look(TreeNode root, int sum, int target, List<List<Integer>> res, List<Integer> list) {
        if (root == null) {
            if (sum == target) {
                List<Integer> list2 = new ArrayList<>();
                for (Integer i : list) {
                    list2.add(i);
                }
                res.add(list2);
            }
        }
        list.add(root.val);
        sum = sum + root.val;
        look(root.left, sum, target, res, list);
        look(root.right, sum, target, res, list);
        list.remove(list.size() - 1);
    }
}
