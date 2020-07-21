package site.zhguixin.algo.LintCode;

public class RemoveDuplicate {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
//        int[] nums = {0,0,1,2,2,3};
        int[] nums = {1,1,1,1,1,1};
        removeDuplicate.remove(nums);
    }

    // [0,0,1,2,2,3]
    // 快慢指针, 移除数组中的重复数据, 不考虑数组末尾的元素
    public int remove(int[] nums) {
        // 快慢指针的思想, slow先指向第一个元素, fast指向第二个元素
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            // 两个元素不一样,直接搬过来
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
                fast++;
            } else { // fast指针移动直到不一样的元素出现
                fast++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        // slow是不重复元素数组的最后一个元素下标
        System.out.println("except duplicate length:" + slow + 1);
        return 0;
    }
}
