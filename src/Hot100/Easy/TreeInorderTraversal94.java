package Hot100.Easy;

import Hot100.TreeNode;

import java.util.ArrayList;
import java.util.List;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TreeInorderTraversal94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inorderTraversalHelper(root, ret);
        return ret;
    }

    private void inorderTraversalHelper(TreeNode treeNode, List<Integer> ret) {
        if (treeNode != null) {
            inorderTraversalHelper(treeNode.left, ret);
            ret.add(treeNode.val);
            inorderTraversalHelper(treeNode.right, ret);
        }
    }

    /*
    前序遍历
    * */
    public List<Integer> PreorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        PreorderTraversalHelper(root, ret);
        return ret;
    }

    private void PreorderTraversalHelper(TreeNode treeNode, List<Integer> ret) {
        if (treeNode != null) {
            ret.add(treeNode.val);
            PreorderTraversalHelper(treeNode.left, ret);
            PreorderTraversalHelper(treeNode.right, ret);
        }
    }

    /*
    后序遍历
    * */
    public List<Integer> PostorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        PostorderTraversalHelper(root, ret);
        return ret;
    }

    private void PostorderTraversalHelper(TreeNode treeNode, List<Integer> ret) {
        if (treeNode != null) {
            PostorderTraversalHelper(treeNode.left, ret);
            PostorderTraversalHelper(treeNode.right, ret);
            ret.add(treeNode.val);
        }
    }
}
