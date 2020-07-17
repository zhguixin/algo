package site.zhguixin.algo.linklist;

public class ReverseLink {

    private LinkNode last;

    // 1-2-3 ;; 3-2-1
    public LinkNode reverse(LinkNode head) {
        return traverse(head);
    }

    // 递归反转链表, 返回反转后的链接头节点
    private LinkNode traverse(LinkNode node) {
        if (node.next == null) {
            return node;
        }
        LinkNode last = traverse(node.next);
        // 递归的出口在倒数第二个节点, 此时node指向倒数第二个节点
        node.next.next = node;
        node.next = null;
        return last;
    }

    // 翻转以head为头节点的前n个节点
    private LinkNode traverseN(LinkNode node, int n) {
        if (n == 1) {
            last = node.next;
            return node;
        }
        LinkNode newHead = traverseN(node.next, n-1);
        node.next.next = node;
        node.next = last;
        return newHead;
    }

    // 翻转第n到第m个节点
    private LinkNode traverseN2M(LinkNode head, int n, int m) {
        // first指向第n个节点, last指向第m个节点
        LinkNode node = head, first, last, preFirst, endLast;
        int i = 1;
        while (node != null) {
            if (i == n) {
                first = node;
            }
            if (i == m) {
                last = node;
            }
            i++;node = node.next;
        }

        // 翻转整个链表
        if (n == 1 && m == i) {
            return traverse(head);
        }

        // TODO 找到前驱后继翻转部分链表
        return null;
    }
}
