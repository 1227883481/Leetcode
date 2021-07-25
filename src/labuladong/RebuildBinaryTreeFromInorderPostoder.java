package labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wgl
 * @create 2021-07-25 22:28
 */
public class RebuildBinaryTreeFromInorderPostoder {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    public TreeNode help(int[] inorder, int leftIn, int rightIn, int[] postorder, int rootIndex) {
        if (rightIn < leftIn) {
            return null;
        }

        // int len = rightIn - leftIn + 1;
        // int index = leftIn; //index表示中序遍历中root的索引
        int index = map.get(postorder[rootIndex]);
        // for (int i = leftIn; i <= rightIn; i++) {
        //     if (inorder[i] == postorder[rootIndex]) {
        //         index = i;
        //         break;
        //     }
        // }
        // int numOfLeft = index - leftIn; //左子树长度
        int numOfRight =  rightIn - index;
        int rightIndex = rootIndex - 1;
        int leftIndex = rootIndex - 1 - numOfRight;
        TreeNode root = new TreeNode(postorder[rootIndex]);
        root.left = help(inorder, leftIn, index - 1, postorder, leftIndex);
        root.right = help(inorder, index + 1, rightIn, postorder, rightIndex);
        return  root;
    }
}
