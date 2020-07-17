package site.zhguixin.algo.tree;

import java.util.HashMap;

public class BSTree {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BSTree bsTree = new BSTree();
        bsTree.traverse(Utils.buildTree());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
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
        System.out.println("after: " + root.getVal());
    }
}
