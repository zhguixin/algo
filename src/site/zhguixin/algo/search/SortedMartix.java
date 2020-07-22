package site.zhguixin.algo.search;

// 在一个二维排序数组中查找指定值
public class SortedMartix {

    // 基本思想: 从【左下角】开始查找, 比target大row--(向上找), 比target小col++(向右找)
    public boolean search(int[][] arr, int target) {
        int row = arr.length -1, col = 0;
        while (row>=0 && col<arr[0].length) {
            if (arr[row][col] > target) {
                row--;
            } else if (arr[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SortedMartix sortedMartix = new SortedMartix();
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        boolean isExist = sortedMartix.search(nums, 3);
        System.out.println("isExist=" + isExist);
    }
}
