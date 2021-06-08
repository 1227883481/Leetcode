package offer;

/**
 * @author wgl
 * @create 2021-05-15 20:43
 */
public class offer027 {

    public static void main(String[] args) {
        offer027 offer027 = new offer027();
        TreeNode root = offer027.getBinaryTree();
        offer027.frontLook(root);

    }

    public void frontLook(TreeNode A) {
        if (A == null) {
            return;
        }
        frontLook(A.left);
        frontLook(A.right);
        System.out.println(A.val);
    }
    public TreeNode getBinaryTree(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        return node1;
    }
}

