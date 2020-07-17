import site.zhguixin.algo.collection.BinaryHeap;
import site.zhguixin.algo.collection.MinStack;
import site.zhguixin.algo.dp.FindMaxVal;
import site.zhguixin.algo.dp.FindMinDst;
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
        findMinDst();
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
        System.out.println(binarySearch.searchBase(arr, 2));
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

    private static void findMinDst() {
        // 动态规划解决最短距离问题
        FindMinDst findMinDst = new FindMinDst();
        int[][] matrix = {
                {1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}
        };
        int minDistance = findMinDst.find(matrix, 4);
        System.out.println("Min Distance is:" + minDistance);
    }
}
