package site.zhguixin.algo.math;

import java.util.HashMap;

// 在一个无序数组中, 寻找和等于target的两个元素
public class TwoSum {

    // 无法使用双指针前后遍历, 因为数组无序, 可以先排序再查找
    // 利用hashmap存放 target - nums[i]
    public void findTwoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // 元素值为key, 元素下标为value, 先把所有元素存在map中
        for (int i=0; i<nums.length;i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length;i++) {
            int other = target - nums[i];
            // map中有target - nums[i], 并且不是本身, 即为合法值
            if (map.containsKey(other) && map.get(other) != i) {
                int[] res = new int[] {i, map.get(other)};
                System.out.println(res);
            }
        }
    }
}
