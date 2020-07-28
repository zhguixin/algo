package site.zhguixin.algo.search;

public class GetSqrt {

    // 给定一个数, 求这个数的平方根
    // 基本思想, 利用二分查找算法
    private float get(float num, float precision) {
        float left = 0f, right = num;
        while (left <= right) {
            float middle = left + (right - left)/2;
            if (Math.abs(num - middle * middle) < precision) {
                return middle;
            } else if (middle * middle > num) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return left;
    }
}
