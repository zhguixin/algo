package site.zhguixin.algo.LintCode;

import java.util.Arrays;

public class KLargest {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        KLargest kLargest = new KLargest();
        int[] nums = {1,3,4,2};
        int n = 1;
        System.out.println(kLargest.kthLargestElement(n, nums));
    }

    public int kthLargestElement(int n, int[] nums) {
        if(n > nums.length) {
            return -1;
        }

        // write your code here
        int index = findKLargest(nums, 0, nums.length -1, n);
        return nums[index];
    }

    // 查找第K大的数, 利用快排的思想让数组从大到小排序
    private int findKLargest(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);
        System.out.println(Arrays.toString(nums));
        System.out.println(pivot);
        if(pivot == k-1) {
            return pivot;
        } else if (pivot > k -1) {//前半部分查找
            return findKLargest(nums, start, pivot-1, k);
        } else {
            return findKLargest(nums, pivot + 1, end, k);
        }
    }

    // partition一次, 比start对应元素大的在左边, 比start对应元素小的在右边, 最后返回start对应元素应在的下标
    private int partition(int[] nums, int start, int end) {
        int low = 0, high = end;
        while(low != high) {
            while(low < high && nums[high] <= nums[start]) high--;
            while(low < high && nums[low] >= nums[start]) low++;

            if (low < high) {
                exchange(nums, low, high);
            }
        }
        exchange(nums, start, low);
        return low;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
