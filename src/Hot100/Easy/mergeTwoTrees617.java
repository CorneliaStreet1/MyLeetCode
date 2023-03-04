package Hot100.Easy;


import Hot100.TreeNode;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。合并的规则是：
 * 如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * */
public class mergeTwoTrees617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return MergeHelper(root1, root2);
    }
    private TreeNode MergeHelper(TreeNode root1, TreeNode root2) {
        TreeNode newRoot = new TreeNode();
        if (root1 ==  null && root2 == null) {
            return null;
        }
        else if (root1 == null && root2 != null) {
            newRoot.val = root2.val;
            newRoot.right = root2.right;
            newRoot.left = root2.left;
        }
        else if (root1 != null && root2 == null) {
            newRoot.val = root1.val;
            newRoot.right = root1.right;
            newRoot.left = root1.left;
        }
        else {
            newRoot.val = root1.val + root2.val;
            newRoot.left = MergeHelper(root1.left, root2.left);
            newRoot.right = MergeHelper(root1.right, root2.right);
        }
        return newRoot;
    }

    public static void main(String[] args) {

    }
}
