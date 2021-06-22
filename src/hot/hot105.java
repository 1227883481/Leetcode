package hot;

import javafx.util.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wgl
 * @create 2021-06-22 10:48
 * 由二叉树的前序和中序遍历结果还原二叉树
 */
public class hot105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        hot105 hot105 = new hot105();
        hot105.buildTree(preorder, inorder);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < inorder.length; i++) {
            list.add(inorder[i]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        help(preorder, 0, list, 0, inorder.length - 1, root, true);
        return root.left;
    }
    public void help(int[] preorder, int index, List<Integer> list, int start, int end, TreeNode root, boolean isLeft) {
        if (index >= preorder.length) {
            return;
        }
        int rootIndex = list.indexOf(preorder[index]);
        TreeNode cur = new TreeNode(preorder[index]);
        if (isLeft) {
            root.left = cur;
        } else {
            root.right = cur;
        }
        if (start < rootIndex) {
            index = index + 1;
            help(preorder, index, list, start, rootIndex - 1, cur, true);
        }
        if (rootIndex < end) {
            index = index + 1;
            help(preorder, index, list, rootIndex + 1, end, cur, false);
        }
    }
}
