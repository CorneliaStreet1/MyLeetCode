package Hot100.Medium;

import Hot100.TreeNode;

import java.util.*;

public class LevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            /*
            * 我们可以用一种巧妙的方法修改广度优先搜索：
            * 首先根元素入队
            * 当队列不为空的时候:
            * 求当前队列的长度 si
            * 依次从队列中取si个元素进行拓展，然后进入下一次迭代
            * 它和普通广度优先搜索的区别在于，普通广度优先搜索每次只取一个元素拓展，而这里每次取 si个元素
             */
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {//第 i 次迭代前，队列中的所有元素就是第 i 层的所有元素，并且按照从左向右的顺序排列。
                TreeNode treeNode = deque.removeFirst();
                if (treeNode != null) {
                    list.add(treeNode.val);
                    if (treeNode.left != null) {
                        deque.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.addLast(treeNode.right);
                    }
                }
                size --;
            }
            ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(5, null, new TreeNode(6));
        (new  LevelOrderTraversal102()).levelOrder(root);
    }
}