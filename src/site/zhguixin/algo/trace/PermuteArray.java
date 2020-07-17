package site.zhguixin.algo.trace;

import java.util.*;

public class PermuteArray {

    private List<List<Integer>> pathList = new LinkedList<>();

    // 给定一个不含重复数字的数组，返回该数组的所有排列
    public List<List<Integer>> getAllPermute(int[] nums) {
        LinkedList<Integer> singlePath = new LinkedList<>();
        traceBack(nums, singlePath);
        return pathList;
    }

    // 每进入一次会将nums中的一个数字加入到path中
    private void traceBack(int[] nums, LinkedList<Integer> path) {
        // 得到一个全排列, 加入到结果集合中
        if (path.size() == nums.length) {
            pathList.add(new LinkedList<>(path));
            return;
        }

        // 循环试探加入数字到全排列中
        for (int i =0; i<nums.length;i++) {
            // 排除掉已经加入的数字
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            traceBack(nums, path);
            path.removeLast();
        }
    }
}
