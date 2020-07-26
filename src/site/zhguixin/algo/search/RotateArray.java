package site.zhguixin.algo.search;

// 旋转数组找最小值
// [3,4,5,1,2]
public class RotateArray {

    public int getMin(int[] nums) {
        int low = 0, high = nums.length -1;

        while (low < high) {
            if (high - low == 1) {
                break;
            }
            int mid = low + (high - low)/2;

            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                // 三个位置上的数字相等, 顺序查找
                return searchInOrder(nums, low, high);
            }
            if (nums[mid] >= nums[low]) {// 前半部分是递增数组
                low = mid;
            } else if (nums[mid] <= nums[high]) {// 后半部分是递增数组
                high = mid;
            }
        }
//        System.out.println("search:" + nums[high]);
        return nums[high];
    }

    private int searchInOrder(int[] nums, int start, int end) {
        int min = nums[start];
        for (int i = start; i <=end;i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
//        System.out.println(min);
        return min;
    }

    // 旋转数组查找target数字
    // 先找到递增区间, 然后递增区间的首尾节点与target比较来进一步确定是否在这个递增区间里
    public int findTarget(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            System.out.println("low=" + low + ";high=" + high);
            int mid = low + (high - low)/2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[low] < nums[mid]) {// [low,mid]是递增区间
                if (nums[low] < target && target < nums[mid]) {
                    // target在这个递增的有序区间里,后续在[low,mid-1]查
                    high = mid-1;
                } else {
                    // 否则在[mid+1,high]这个区间里查找
                    low = mid+1;
                }
            } else {// [mid, high]是递增区间
                if (nums[high] > target && nums[mid] < target) {
                    // target在这个有序区间里
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        int[] nums = {3,4,5,1,2};
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {1,1,0,1,1};
        int[] nums = {1,0,1,1,1};
        RotateArray rotateArray = new RotateArray();
        int res = rotateArray.getMin(nums);
        System.out.println("res=" + res);
        int index = rotateArray.findTarget(nums,0);
        System.out.print("index=" + index);
    }
}
