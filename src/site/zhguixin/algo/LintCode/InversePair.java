package site.zhguixin.algo.LintCode;

// 利用归并排序的思想查找数组中的逆序对
public class InversePair {

    private int[] temp;
    public int sort(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low)/2;
        int left = mergeSort(nums, low, mid);
        int right = mergeSort(nums, mid + 1, high);
        int count = merge(nums, low, mid, high);
        System.out.println("left=" + left + ";right=" + right + ";count=" + count);
        return left + right + count;
    }

    private int merge(int[] nums, int start, int mid, int end) {
        int low = start, high = mid + 1, k = 0;
        int count = 0;

        while (low <= mid && high <= end) {
            if (nums[low] <= nums[high]) {
                temp[k++] = nums[low++];
            } else {
                temp[k++] = nums[high++];
                // 第一个有序数组的首位数字大于第二个排序数组的首位数字
                // 那么后面的数字都构成逆序对
                count += mid - low + 1;
            }
        }

        // 第一个有序数组还有剩余, 继续放到temp中
        while (low <= mid) {
            temp[k++] = nums[low++];
        }

        // 第二个有序数组还有剩余, 继续放到temp中
        while (high <= end) {
            temp[k++] = nums[high++];
        }

        // 将temp中的有序元素在放回到nums[start..end]中去
        for (int i = start, j = 0; i <= end && j < k;j++, i++) {
            nums[i] = temp[j];
        }

        return count;
    }

    public static void main(String[] args) {
        InversePair inversePair = new InversePair();
        int[] nums = {7,5,6,4};
        int res = inversePair.sort(nums);
        System.out.println("res=" + res);
    }
}
