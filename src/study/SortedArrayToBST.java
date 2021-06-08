package study;

/**
 * @author wgl
 * @create 2021-04-23 11:28
 */
public class SortedArrayToBST {

    public static void main(String[] args) {
        boolean[] i = new boolean[5];
        Integer[] j = new Integer[5];
        int[] k = new int[5];
        System.out.println(i[1]);
        System.out.println(j[1]);
        System.out.println(k[1]);
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int count = nums.length;
        int mid = count/2;
        TreeNode root = new TreeNode(nums[mid]);
        for (int i = mid - 1, j = mid + 1; i >=0 || j < count; i--, j++) {
            addNode(root, new TreeNode(nums[i]));
            if (j >= count) {
                break;
            }
            addNode(root, new TreeNode(nums[j]));
        }
        return root;
    }

    public void addNode(TreeNode root, TreeNode newNode) {
        //向二叉树添加元素
        if (root.left == null && newNode.val < root.val) {
            root.left = newNode;
            return;
        }
        if (root.right == null && newNode.val > root.val) {
            root.right = newNode;
            return;
        }
        if (newNode.val < root.val) {
            addNode(root.left, newNode);
        } else {
            addNode(root.right, newNode);
        }
    }
    public boolean isBanllence(TreeNode root) {
        //判断是否为平衡二叉树
        if (Math.abs(deep(root.left) - deep(root.right)) <= 1) {
            return true;
        } else {
            return false;
        }
    }
    public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDeep = deep(root.left);
        int rightDeep = deep(root.right);
        if (leftDeep > rightDeep) {
            return leftDeep + 1;
        } else {
            return rightDeep + 1;
        }
    }
}
