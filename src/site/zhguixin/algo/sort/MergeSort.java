package site.zhguixin.algo.sort;

// 归并排序
public class MergeSort {

    private int[] temp;

    public void sort(int[] nums) {
        temp = new int[nums.length];
        sortInternal(nums, 0, nums.length - 1);
    }

    // 分治过程, 先将原始数组拆分
    private void sortInternal(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low)/2;
        sortInternal(nums, low, mid);
        sortInternal(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    // 合并过程：新开辟一个临时数组，将两个待排序的数组取出较小值，放入到临时数组中。
    // 都拷贝完成后，临时数组中的值都是已经排好序的了，再将temp中的数组值拷贝回原数组
    // 在数组nums中, [start, mid] [mid+1, right]分别有序, merge的作用就是将两个有序数组合并为一个有序数组(先存放到temp中再吐回去)
    // 类似于: 合并两个有序链表
    private void merge(int[] nums, int start, int mid, int end) {
        int low = start, high = mid + 1, k = 0;

        while (low <= mid && high <= end) {
            if (nums[low] < nums[high]) {
                temp[k++] = nums[low++];
            } else {
                temp[k++] = nums[high++];
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
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int [] nums = {3,2,1,5};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(nums);

        for (int i = 0; i <nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
