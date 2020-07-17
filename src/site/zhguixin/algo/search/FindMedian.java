package site.zhguixin.algo.search;

public class FindMedian {

    // 给定两个已排好序的数组, 求这两个有序数组的中位数
    public int find(int[] nums1, int[] nums2) {

        return 0;
    }

    // 转换为求两个排序数组第K的数
    private int findKLargest(int[] nums1, int nums1Start, int nums1End, int[] nums2, int nums2Start, int nums2End, int k) {
        int tempK = k / 2;
        int len1 = nums1End - nums1Start + 1;
        int len2 = nums2End - nums2Start + 1;
        // 确保nums1是最短数组
        if (len1 > len2) return findKLargest(nums2, nums2Start, nums2End, nums1, nums1Start, nums2End, k);

        // 最短数组长度为0时,第k大数在nums2中
        if (len1 == 0) return nums2[nums2Start + k - 1];

        int i = len1 / 2, j = len2 / 2;
        int kLargestInNums1 = nums1[i];
        int kLargestInNums2 = nums2[j];

        if (kLargestInNums1 == kLargestInNums2) {
            return tempK;
        } else if (kLargestInNums1 > kLargestInNums2) {
            // nums1[0, length) nums2[j + 1, length)
            // k - (j - nums2Start + 1)
            findKLargest(nums1, nums1Start, nums1End, nums2, j + 1, nums2End, k - (j - nums2Start + 1));
        } else {

        }
        return 0;
    }

}
