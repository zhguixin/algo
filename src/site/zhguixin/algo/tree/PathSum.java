package site.zhguixin.algo.tree;

import java.util.ArrayDeque;
import java.util.Deque;

// 在一个二叉树上寻找所有路径和等于target的路径
// https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/di-gui-xiang-jie
public class PathSum {

    public int pathSum(TreeNode<Integer> root, int target) {
        if (root == null) {
            return 0;
        }

        int rootPath = count(root, target);
        int leftPath = pathSum(root.getLeft(), target);
        int rightPath = pathSum(root.getRight(), target);

        return rootPath + leftPath + rightPath;
    }

    private int count(TreeNode<Integer> node, int num) {
        if (node == null) {
            return 0;
        }

        int rootNum = (node.getVal() == num) ? 1 : 0;
        int leftNum = count(node.getLeft(), num - node.getVal());
        int rightNum = count(node.getRight(), num - node.getVal());
        return rootNum + leftNum + rightNum;
    }

    private Deque<TreeNode> stack = new ArrayDeque<>();
    // 和为某一个值得路径, 到叶子节点才算一个路径
    // 回溯求解
    public void getPath(TreeNode<Integer> root, int excepted) {
        if (root == null) {
            return;
        }

        stack.push(root);
        excepted -= root.getVal();
        if (excepted == 0 && isLeaf()) {
            // add a path
        }
        getPath(root.getLeft(), excepted);
        getPath(root.getRight(), excepted);
        stack.pop();
    }

    private boolean isLeaf() {
        return true;
    }
}
