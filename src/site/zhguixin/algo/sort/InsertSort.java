package site.zhguixin.algo.sort;

public class InsertSort {

    // 从小到大排序
    // 该排序是找到插入位置后, 再插入, 找到位置后只需要一次交换
    public void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {// 取未排序集合中的元素
            int temp = nums[i];
            int j;
            for (j = i; j >= 0 && nums[j-1] > temp; j--) {// 对比已排序好的元素将该元素插入到合适位置
                nums[j] = nums[j - 1];
            }
            // j即为要插入的位置
            nums[j] = temp;
        }
    }

    // 从小到大排序
    // 该排序是将待插入的元素从已排序好的序列最后一个位置一次次往前交换, 需要多次交换
    public void sortV2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j -1] > nums[j]; j--) {
                exchange(nums, j -1, j);
            }
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
