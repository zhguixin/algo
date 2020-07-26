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

    private LinkNode reversePair(LinkNode node) {
        if (node.next == null) {
            return node;
        }

        LinkNode newHead = node.next;
        node.next = reversePair(newHead.next);
        newHead.next = node;
        return newHead;
    }

    // k个一组反转链表
    private LinkNode reverseKGroup(LinkNode head, int k) {
        if (head == null) {
            return null;
        }

        LinkNode nodeTemp = head;
        LinkNode nodeHeadTemp = head;
        for (int i = 0; i < k; i++) {
            if (nodeTemp == null) {
                return head;
            }
            nodeTemp = nodeTemp.next;
        }

        LinkNode newHead = reverseBetween(nodeHeadTemp, nodeTemp);
        nodeHeadTemp.next = reverseKGroup(nodeTemp, k);

        return newHead;
    }

    private LinkNode reverseBetween2(LinkNode node1, LinkNode node2) {
        LinkNode pre = node1, cur = node1.next;

        while (cur != node2) {
            LinkNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归反转node1~node2之间的链表
    private LinkNode reverseBetween(LinkNode node1, LinkNode node2) {
        if (node1.next == node2) {
            return node1;
        }
        LinkNode last = reverseBetween(node1.next, node2);
        node1.next.next = node1;
        node1.next = null;
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
        if (n == 1) {
            return traverseN(head, m);
        }
        // 找到n =1, 开始翻转
        traverseN2M(head.next, n -1, m-1);
        return null;
    }

    // 迭代的方式反转链表
    // 三个指针分别指向pre cur temp, 翻转节点就是将cur节点指向pre; temp的作用就是保存cur的next指向, 避免反翻转后指向丢失
    // pre  cur temp
    // 1 -- 2 -- 3
    public LinkNode reverse2(LinkNode head) {
        LinkNode pre = head, cur = head.next;
        while (cur != null) {
            // 先把当前节点的下一个保存起来, 否则改变指针指向之后就拿不到该节点了
            LinkNode temp = cur.next;
            // 当前节点的next指针向前指
            cur.next = pre;
//            pre.next = null;
            // pre指针向前走
            pre = cur;
            // cur指针向前走
            cur = temp;
        }

        // 头结点指针现在变成尾节点了
        head.next = null;
        return pre;
    }

    // 翻转相邻的两个节点
    // 三个指针分别指向pre cur temp, 翻转节点就是将cur节点指向pre; temp的作用就是保存cur的next指向, 避免反翻转后指向丢失
    // 两两反转的情况下, 还需要保存一个节点, 那就是tail, tail指向上一个已经反转了的链表尾节点, 用来把即将翻转到头的cur连接起来
    public LinkNode reversePair2(LinkNode head) {
        LinkNode pre = head, cur = head.next;
        LinkNode tail = null;
        LinkNode newHead = (cur == null ? pre : cur);

        while (cur != null) {
            LinkNode temp = cur.next;
            cur.next = pre;// 翻转指向
            pre.next = temp;

            if (tail != null) {
                tail.next = cur;
            }
            if (temp == null) {
                break;
            }

            tail = pre;
            pre = temp;
            cur = temp.next;// cur走两步步长
        }

        return newHead;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkNode a1 = new LinkNode(1);
        LinkNode a2 = new LinkNode(2);
        LinkNode a3 = new LinkNode(3);
        LinkNode a4 = new LinkNode(4);
        LinkNode a5 = new LinkNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ReverseLink reverseLink = new ReverseLink();
        LinkNode head = reverseLink.reverseKGroup(a1, 2);
//        LinkNode head = reverseLink.reverse2(a1);
        LinkNode tempHead = head;
        while (tempHead != null) {
            System.out.println(tempHead.val);
            tempHead = tempHead.next;
        }
    }
}
