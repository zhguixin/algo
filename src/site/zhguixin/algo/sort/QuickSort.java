package site.zhguixin.algo.sort;

import java.util.Arrays;

public class QuickSort {

//    public static void main(String[] args) {
////        int [] nums = {9,8,8,7,6,6,5,4,3,2,1};
//        int [] nums = {3,2,1,5};
//        QuickSort quickSort = new QuickSort();
//        quickSort.sort(nums);
////        quickSort.partition(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(3%2);
//    }

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    // 此次排序后, 比pivot下标对应元素小的挪到pivot前面, 比pivot下标对应元素大的挪到pivot后面, 并返回pivot
    // 这里选择第一个元素作为pivot
    private int partition(int[] nums, int start, int end) {
        int pivot = start;
        int i = start;
        int j = end;

        // 只有i 和 j不相等, 就进行挪动
        while (i != j) {
            // 只要尾结点元素大于pivot元素, 尾结点指针就向前移动
            while (i < j && nums[j] >= nums[pivot]) j--;
            // 只要头结点元素小于pivot元素, 头结点指针就向后移动
            while (i < j && nums[i] <= nums[pivot]) i++;
            // 交换不符合条件的两个元素: 尾部元素小于pivot, 头部元素大于pivot
            System.out.println("i=" + i + ";j=" + j);
            if (i < j) exchange(nums, i, j);
        }

        System.out.println(i);
        exchange(nums, start, i);
        return i;
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
