package site.zhguixin.algo.math;

public class Pow {

    // x的n次幂, 时间复杂度O(n)
    public int getPow(int x, int n) {
        int res = 1, pow = 1;

        for (int i = 1; i <= n; i++) {
            res = pow * x;
            pow = pow * x;
        }

        return res;
    }

    // 时间复杂度O(logn), 每次进行折半
    // n < 0时, 渠道数: 1.0 / getPow(x, -n)
    public int getPow2(int x, int n) {
        if (n == 0) {
            return 1;
        }

        int half = getPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        Pow pow = new Pow();
        int res = pow.getPow(2,10);
        System.out.println("res=" + res);
    }
}
