package site.zhguixin.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindMiniDeep {

    // 利用广度优先遍历(BFS)，将加入到队列queue中的所有元素向四周扩散,知道找到叶子节点
    public int find(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            // 向四周扩散节点
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll();
                if (cur.getLeft() == null && cur.getRight() == null) {
                    return depth;
                }
                // 将cur相邻的节点加入队列
                if (cur.getRight() != null) queue.offer(cur.getRight());
                if (cur.getLeft() != null) queue.offer(cur.getLeft());
            }
            // 增加步数
            depth++;
        }
        return depth;
    }
}
