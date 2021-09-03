package experience;

import labuladong.TreeNode;

/**
 * @author wgl
 * @create 2021-09-03 11:28
 * 测试令当前树节点为null会不会影响上一层递归
 */
public class rootEquNullTest {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        rootEquNullTest rootEquNullTest = new rootEquNullTest();
        rootEquNullTest.isZero(node2);
        System.out.println(node2);
        System.out.println("完成");

    }
    public void isZero(TreeNode root) {
        System.out.println(root);
        root = new TreeNode(5);
        System.out.println(root);
//        if (root.val == 2) {
////            root = null;
//            root.val = 3;
//        }
    }
}
