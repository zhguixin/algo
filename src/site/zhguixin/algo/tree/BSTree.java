package site.zhguixin.algo.tree;

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


}
