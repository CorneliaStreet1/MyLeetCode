package Hot100.Medium;

import Hot100.ListNode;
import Hot100.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/*给你一个二叉树的根结点 root ，请你将它展开为一个单链表：
展开后的单链表应该同样使用 TreeNode ，
其中 right 子指针指向链表中下一个结点，而左子指针始终为 null
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class BSTtoLinkedList114 {
    /*    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode newRoot = helper(root);
    }
    private TreeNode helper(TreeNode root) {
        if (root != null) {
            TreeNode newroot = new TreeNode();
            newroot.val = root.val;
            newroot.right = helper(root.left);
            if (newroot.right != null) {
                newroot.right.right = helper(root.right);
            }
            return newroot;
        }
        return null;
    }*/
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> n = new ArrayList<>();
        PreOrder(root, n);
        //for (int)
        TreeNode ret;
        ret = n.get(0);
        TreeNode pre = ret;
        for (int i = 1; i < n.size(); i ++) {
            TreeNode curr = n.get(i);
            pre.right = curr;
            pre.left = null;
            pre = curr;
        }
        System.out.println();
    }

    private void PreOrder(TreeNode root, List<TreeNode> nums) {
        if (root != null) {
            nums.add(root);
            PreOrder(root.left, nums);
            PreOrder(root.right, nums);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));
        (new BSTtoLinkedList114()).flatten(root);
    }
}
