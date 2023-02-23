package Hot100.Easy;

import Hot100.TreeNode;

public class maxDepth104 {
    public int maxDepth(TreeNode root) {
        return Depth(root);
    }
    /*
    一棵树的深度，等于它的左右子树的深度中更大的那个值，再加上加上它本身的深度1.（也即，一棵树的深度，是其左右子树深度的较大者加一）
    所以是递归的解法。
    * */
    private int Depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        else {
            int L = Depth(node.left) + 1;
            int R = Depth(node.right) + 1;
            return Math.max(L, R);
        }
    }
    /*
    试一下非递归的方法
    魔改的层序遍历，不同于层序遍历的地方是，我们不是一次弹出一个节点，而是一次弹出一层的节点，并且每弹出一次，层计数器++。
    * */
}
