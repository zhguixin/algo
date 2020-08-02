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

    private int getSqrt(int num, float precision) {
        int left = 0, right = num / 2;
        int last_middle = 0;
        while (left <= right) {
            int middle = left + (right - left)/2;
            if (num / middle > middle) {
                left = middle + 1;
                last_middle = middle;
            } else if (num / middle < middle) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return last_middle;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        GetSqrt getSqrt = new GetSqrt();
        float res = getSqrt.get(3f, 0.01F);
        System.out.print("res=" + res);
    }
}
