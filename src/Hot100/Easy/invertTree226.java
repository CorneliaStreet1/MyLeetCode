package Hot100.Easy;

import Hot100.TreeNode;

public class invertTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //反转左子树
        TreeNode left = invertTree(root.left);
        //反转右子树
        TreeNode right = invertTree(root.right);
        //左右交换root的两棵子树
        root.left = right;
        root.right = left;
        return  root;
    }
}
