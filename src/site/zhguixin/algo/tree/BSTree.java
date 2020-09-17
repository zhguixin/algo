package site.zhguixin.algo.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BSTree {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BSTree bsTree = new BSTree();
        TreeNode root = Utils.buildTree();
        TreeNode newRoot = bsTree.mirror(root);

        PrintLayer printLayer = new PrintLayer();
        printLayer.println(newRoot);
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println("before: " + root.getVal());
        // before
        traverse(root.getLeft());
        // middle
        traverse(root.getRight());
        // after
//        System.out.println("after: " + root.getVal());
    }

    // 镜像一个二叉树
    public TreeNode mirror(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = mirror(node.getLeft());
        TreeNode right = mirror(node.getRight());

        node.setLeft(right);
        node.setRight(left);
        return node;
    }

    // 第k层的节点数
    public int getKLayerNum(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getKLayerNum(root.getLeft(), k -1) + getKLayerNum(root.getRight(), k - 1);
    }

    // 返回节点p和q的最近公共父节点
    // 参考：https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/gong-gong-zu-xian
    public TreeNode getLowestCommonParent(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {// p或者q其中一个为父节点, 就直接返回父节点
            return root;
        }

        // getLowestCommonParent该函数返回p和q的最近公共父节点,(永远不要怀疑这点,更不能陷入递归的深渊)
        // 递归调用后left表示: p和q在root的左子树上最近公共父节点是left
        TreeNode left = getLowestCommonParent(root.getLeft(), p ,q);
        // 递归调用后right表示: p和q在root的右子树最近公共父节点是right
        TreeNode right = getLowestCommonParent(root.getRight(), p, q);

        // 画个图一看, left, right都不null, 那么p、q的最近公共父节点不就是left和right的父节点了吗，就是root
        if (left != null && right != null) {
            return root;
        }

        // p 和 q都不在以root为根的树上
        if (left == null && right == null) {
            return null;
        }

        // 返回不为null的那个节点
        return left == null ? right : left;
    }

    // 把一个二叉搜索树变为有序的双向链表
    // 中序遍历二叉树, 对于某个节点node,
    public void convertToDualList(TreeNode root) {
        TreeNode lastNodeInList;
        TreeNode head = realConvert(root, null);
        // 反转head
    }

    // lastNode表示翻转二叉树后得到双向链表的的最后一个节点
    // 网上有个思路: 先递归调用后得到中序遍历的节点放到队列中, 然后依次从队列中取出节点, 再改变left和right的指向
    // https://blog.csdn.net/hahaEverybody/article/details/90270966
    // 递归处理的思想
    private TreeNode realConvert(TreeNode node, TreeNode lastNode) {
        if (node == null) {
            return lastNode;
        }
        TreeNode cur = node;
        if (cur.getLeft() != null) {
            lastNode = realConvert(node.getLeft(), lastNode);
        }
        cur.setLeft(lastNode);

        // 当前节点转换为双链表时, 应为lastNode的右节点指向
        if (lastNode != null) {
            lastNode.setRight(cur);
        }

        lastNode = cur;
        if (cur.getRight() != null) {
            lastNode = realConvert(node.getRight(), lastNode);
        }
        return lastNode;
    }


    // https://blog.csdn.net/beitiandijun/article/details/41941211
    // 按层遍历第K层的节点数目
//    public int getKLayerNum2(TreeNode root, int k) {
//        if (root == null || k <= 0) {
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        int curLayer = 1, kLayerNum = 0;
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            kLayerNum = queue.size();
//
//            for (int i = 0; i<kLayerNum; i++) {
//                TreeNode node = queue.poll();
//                if (node.getLeft() != null) {
//                    queue.offer(node.getLeft());
//                }
//                if (node.getRight() != null) {
//                    queue.offer(node.getRight());
//                }
//            }
//            curLayer++;
//            if (curLayer == k) {
//                break;
//            }
//        }
//        return kLayerNum;
//    }

    int min  = Integer.MAX_VALUE;
    TreeNode pre = null;
    // 二叉搜索树节点绝对值得最小值
    public void getDif(TreeNode root) {
        if (root == null) {
            //
        }

        getDif(root.getRight());
        if (pre != null) {
//            min = Math.min(min, root.getVal() - pre.getVal());
        }
        getDif(root.getLeft());

    }
}
