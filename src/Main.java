import site.zhguixin.algo.collection.BinaryHeap;
import site.zhguixin.algo.collection.MinStack;
import site.zhguixin.algo.dp.FindMaxVal;
import site.zhguixin.algo.dp.FindMinDistance;
import site.zhguixin.algo.math.MaxCapacity;
import site.zhguixin.algo.search.BinarySearch;
import site.zhguixin.algo.sort.QuickSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
//        heapSort();
//        binarySearch();
//        findMaxVal();
//        findMathCapacity();
//        getMinInStack();
//        findMinDistance();
        iterator();
    }

    /**
     * 堆排序, 通过二叉堆实现
     */
    private static void heapSort() {
        int [] arr = {9,8,7,6,5,4,3,2,1};
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(arr.length);
        for (int i : arr) {
            binaryHeap.insert(i);
        }
        System.out.println(binaryHeap.toString());
    }

    private static void binarySearch() {
        int [] arr = {1,2,2,2,3,4};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(arr, 2));
    }

    private static void quickSort() {
        int [] nums = {3,2,1,5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void findMaxVal() {
        int [] arr = {1,-2,3,10,-4,7,2,-5};
        FindMaxVal findMaxVal = new FindMaxVal();
        System.out.println(findMaxVal.findMaxSum(arr));
    }

    private static void findMathCapacity() {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        MaxCapacity maxCapacity = new MaxCapacity();
        System.out.println(maxCapacity.max(arr));
    }

    private static void getMinInStack() {
        MinStack minStack = new MinStack();
        minStack.push(2);minStack.push(1);minStack.push(3);minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();minStack.pop();
        System.out.println(minStack.getMin());
    }

    private static void findMinDistance() {
        // 动态规划解决最短距离问题
        FindMinDistance findMinDistance = new FindMinDistance();
        int[][] matrix = {
                {1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}
        };
        int minDistance = findMinDistance.find(matrix, 4);
        System.out.println("Min Distance is:" + minDistance);
    }

    private static void iterator() {
        int[][] arr = new int[3][3];
        int m= 0;
        for (int i =0;i <3;i++) {
            for (int j=0;j<3;j++) {
                arr[i][j] = m++;
            }
        }
//        for (int i =0;i <3;i++) {
//            for (int j=0;j<3;j++) {
//                System.out.println("i=" + i + ";j=" + j+";arr[i][j]:" + arr[i][j]);
//            }
//        }
        // i从后往前遍历,j一直保持在i的右边.求最长回文子序列时,用到这种遍历方式
        for (int i =3;i >=0;i--) {
            for (int j=i;j<3;j++) {
                System.out.println("i=" + i + ";j=" + j+";arr[i][j]:" + arr[i][j]);
            }
        }
    }
}
