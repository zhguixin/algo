package site.zhguixin.algo.trace;

import site.zhguixin.algo.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// 和为某一个值的所有路径, 根节点到叶子结点为一个路径
public class TreePath {

    private Deque<TreeNode> stack = new ArrayDeque<>();

    public void getPaths(TreeNode<Integer> root, int curSum, int exceptedSum) {
        if (root == null) {
            return;
        }

        curSum += root.getVal();
        stack.push(root);
        boolean isLeaf = root.getLeft() == null && root.getRight() == null;
        if (isLeaf && curSum == exceptedSum) {
            // 栈中的结点放到List中
        }

        getPaths(root.getLeft(), curSum, exceptedSum);
        getPaths(root.getRight(), curSum, exceptedSum);
        stack.pop();
    }
}
