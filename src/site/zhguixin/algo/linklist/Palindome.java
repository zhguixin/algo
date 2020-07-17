package site.zhguixin.algo.linklist;

public class Palindome {

    private LinkNode left;

    public boolean isPalindome(LinkNode root) {
        left = root;
        return traverse(root);
    }

    // 利用递归栈比较前后节点
    private boolean traverse(LinkNode node) {
        if (node == null) {
            return true;
        }
        boolean result = traverse(node.next);
        boolean isSame = (node.val == left.val);
        left = left.next;
        return result && isSame;
    }
}
