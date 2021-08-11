package git;

import labuladong.TreeNode;

import java.util.*;

/**
 * @author wgl
 * @create 2021-08-10 23:56
 */
public class lc652 {
    List<TreeNode> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        help(root);
        return list;
    }

    public String help(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String s1 = help(root.left);
        String s2 = help(root.right);
        String s3 = s1 + "," + s2 + "," + root.val;
        if (map.getOrDefault(s3, 0) > 0) {
            if (map.getOrDefault(s3, 0) == 1) {
                list.add(root);
                map.put(s3, 2);
            }

        } else {
            map.put(s3, 1);
        }
        int i = 0;
        return s3;

    }
}
