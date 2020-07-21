package site.zhguixin.algo.trace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 给定一个数组num={1,2,3}, 找到所有的子序列：{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}
public class SubSequence {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SubSequence subSequence = new SubSequence();
        int[] nums = {1,2};
        List<List<Integer>> result = subSequence.findSubSeq(nums);
        System.out.println(result);
    }

    public List<List<Integer>> findSubSeq(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(nums, 0, new LinkedList<>(), res);
        return res;
    }

    private void backTracking(int[] nums, int index, LinkedList<Integer> seq, List<List<Integer>> res) {
        System.out.println(seq);
        // 每个序列过来都是合法的子序列
        res.add(new LinkedList<>(seq));
        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            seq.add(nums[i]);
            backTracking(nums, i + 1, seq, res);
            seq.removeLast();
        }
    }
}
