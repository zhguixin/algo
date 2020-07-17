package site.zhguixin.algo.tree;

public class Utils {


    public static TreeNode buildTree() {
        TreeNode<String> root = new TreeNode<String>("a");
        TreeNode<String> leftL1 = new TreeNode<String>("b");
        TreeNode<String> rightL1 = new TreeNode<String>("c");
        TreeNode<String> leftL21 = new TreeNode<String>("d");
        TreeNode<String> rightL21 = new TreeNode<String>("e");
        TreeNode<String> leftL22 = new TreeNode<String>("f");
        TreeNode<String> rightL22 = new TreeNode<String>("g");
        TreeNode<String> leftL31 = new TreeNode<String>("h");
        root.setLeft(leftL1);root.setRight(rightL1);
        leftL1.setLeft(leftL21);leftL1.setRight(rightL21);
        rightL1.setLeft(leftL22);rightL1.setRight(rightL22);
        leftL21.setLeft(leftL31);
        return root;
    }
}
