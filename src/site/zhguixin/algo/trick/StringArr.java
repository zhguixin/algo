package site.zhguixin.algo.trick;

import site.zhguixin.algo.tree.TreeNode;

import java.util.HashMap;

// 最长公共前缀, 字符串只包含小写字母
//输入: ["flower","flow","flight"]
//        输出: "fl"
public class StringArr {

    // 暴力法解决, 公共前缀肯定是最短的字符，可以遍历一遍得到最短的字符串,依次考察最短字符串的子串是否是公共前缀
    public void get(String[] arr) {
        String shortStr = arr[0];
        for (String str : arr) {
            if (shortStr.length() > str.length()) {
                shortStr = str;
            }
        }

        int shortLen = shortStr.length();

        boolean isMax = true;
        // 最大前缀, 倒着考察:shortStr.substring(0, shortLen);
        while (shortLen > 0) {
            String prefix = shortStr.substring(0, shortLen);
            for (int i = 0; i < arr.length;i++) {
                // 只要一个不相等, shortLen--继续考察
                if (!arr[i].startsWith(prefix)) {
                    isMax = false;
                    break;
                }
            }

            if (isMax) {
                break;
            }
            shortLen--;
        }

        String res = shortStr.substring(0, shortLen);
    }

    // 构造字典树
    // https://www.jianshu.com/p/cf0b4e653548
    public void getMaxPrefix(String[] arr) {

    }

    // Tire树的实现:https://blog.csdn.net/weixin_40374341/article/details/94028364
    class TrieTree {

        TrieNode root;

        public TrieTree() {
            root = new TrieNode();
        }

        public void insert(String str) {
            char[] arr = str.toCharArray();
            TrieNode node = root;
            node.path++;

            for (int i=0;i<arr.length;i++) {
                if (!node.map.containsKey(arr[i])) {
                    node.map.put(arr[i], new TrieNode());
                }
                node = node.map.get(arr[i]);
                node.path++;
            }
            node.end++;
        }

        public void delete(String str) {
            char[] arr = str.toCharArray();
            TrieNode node = root;
            node.path--;

            for (int i=0;i < arr.length;i++) {
                int path = node.map.get(arr[i]).path;
                if (--path == 0) {
                    node.map.remove(arr[i]);
                    return;
                }
                // 下一个节点
                node = node.map.get(arr[i]);
            }
            node.end--;
        }

    }

    class TrieNode {
        HashMap<Character, TrieNode> map;
        // map中的每一个字符被涵盖了几次
        int path;
        // 插入了几个单词
        int end;

        TrieNode() {
           map = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        TrieTree trieTree = new StringArr().new TrieTree();
        trieTree.insert("aaa");
    }
}
