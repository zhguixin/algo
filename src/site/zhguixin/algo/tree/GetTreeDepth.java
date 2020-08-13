package site.zhguixin.algo.tree;

import java.util.Arrays;

// 求二叉树的最大深度
public class GetTreeDepth {

    public int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getMaxDepth(node.getLeft());
        int right = getMaxDepth(node.getRight());

        return Math.max(left, right) + 1;
    }

    // 根节点到叶子节点的最小深度:
    public int getMinDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = getMinDepth(node);
        int right = getMinDepth(node);

        // 左右节点为空, 返回不为空的节点加一
        if (left == 0 || right == 0) {
            return left + right + 1;
        }

        return Math.min(left, right) + 1;
    }


    public static void main(String[] args) {
        GetTreeDepth getTreeDepth = new GetTreeDepth();
        getTreeDepth.getMaxDepth(null);
    }
}
