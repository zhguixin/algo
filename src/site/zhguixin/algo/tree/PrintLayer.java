package site.zhguixin.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

// 按层打印二叉树
public class PrintLayer {

    private Queue<TreeNode> queue;

    public PrintLayer() {
        queue = new LinkedList<>();
    }

    public void print(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        // BFS算法, 队列中的元素向四周扩散
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getVal());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
    }

    // 每打印一行输入换行符
    public void println(TreeNode root) {
        if (root == null) {
            return;
        }
        queue.offer(root);
        System.out.println(root.getVal());
        TreeNode last = null;//即将入队的最后一个节点
        TreeNode lastInQueue = root;//已经入队中的最后一个节点
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.getLeft() != null) {
                System.out.print(node.getLeft());
                last = node.getLeft();
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                System.out.print(node.getRight());
                last = node.getRight();
                queue.offer(node.getRight());
            }
            // 已经取到队列的最后一个节点, 换行
            if (lastInQueue == node) {
                System.out.println();
                // 更新此时队列中的最后一个节点
                lastInQueue = last;
            }
        }
    }
}
