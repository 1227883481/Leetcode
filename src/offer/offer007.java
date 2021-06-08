package offer;

import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgl
 * @create 2021-05-10 15:14
 */
public class offer007 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        List<Integer> preorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
        }
        int rootval = preorder[0];
        TreeNode root = new TreeNode(rootval);
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (rootval == inorder[i]) {
                index = i;
                break;
            }
        }
        preorderList.remove(0);
        root.left = build(preorderList, inorder, 0, index - 1);
        root.right = build(preorderList, inorder, index + 1, inorder.length - 1);
        return root;
    }

    public TreeNode build(List<Integer> preorderList, int[] inorder, int l, int r) {
        if (l > r || preorderList.size() == 0) {
            return null;
        }
        int rootval =  preorderList.get(0);
        TreeNode root = new TreeNode(rootval);
        int index = -1;

        for (int i = l; i <= r; i++) {
            if (rootval == inorder[i]) {
                index = i;
                break;
            }
        }
        preorderList.remove(0);

        root.left = build(preorderList, inorder, 0, index - 1);
        root.right = build(preorderList, inorder, index + 1, inorder.length);
        return root;

    }
}


class TreeNode {
    int val;
    TreeNode right;
    TreeNode left;

    TreeNode(int x) {
        val = x;
    }
}
