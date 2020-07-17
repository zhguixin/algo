package site.zhguixin.algo.search;

public class BinarySearch {

    public int searchBase(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return -1;
    }

    // [1,2,2,2,3]
    public int search(int[] nums, int target) {
        // 搜索区间左闭右开: [left,right)
        int left = 0, right = nums.length;
        while (left < right) {
            // 搜索区间由mid隔开: [left,mid)  [mid + 1,right)
            int mid = left + (right - left)/2;
            // 找到target后不直接返回,减小搜索区间的上边界right, 找到第一个等于target的元素下标
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        // 返回right也可以，因为while的退出条件是right=left;
        // left表示第一个等于target的元素下标
        // 此处left的含义也可以解读为数组中小于target的元素个数

        // left的滑动区间为[0, nums.length]
        // 此处判断避免越界
        if (left == nums.length) {
            return -1;
        }
        if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    // 该函数查找等于给定数组nums中最后一个等于target的元素下标
    // nums = [1,2,2,2,3], target = 2, 返回下标3
    public int searchV2(int[] nums, int target) {
        // 搜索区间左闭右开: [left,right)
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            // 找到target后不直接返回,增大搜索区间的下边界left, 找到最后一个等于target的元素下标
            if (nums[mid] == target) {
                left = mid + 1;// 需要返回left - 1,才能正确返回最后一个等于target的元素下标
            } else if (nums[mid] < target) { // target值在mid右边, 收缩左边界
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        // left的滑动区间为[0, nums.length]
        // 此处判断避免越界
        if (left == 0) {
            return -1;
        }
        if (nums[left - 1] == target) {
            return left - 1;
        } else {
            return -1;
        }
    }
}
