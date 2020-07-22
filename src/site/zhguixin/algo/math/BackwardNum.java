package site.zhguixin.algo.math;

// 逆序一个整数
public class BackwardNum {

    public int backward(int num) {
        int result = 0, temp = num;

        while (temp != 0) {
            // 乘以10是关键, 每次得到个位数, 把上次的结果乘以10
            result = result * 10 + temp % 10;
            temp = temp / 10;// 舍弃个位
        }
        return result;
    }

    // 给定一个整数, 获取这个整数有多少位
    public int getDigital(int num) {
        int count = 0, temp = num;
        while (temp != 0) {
            temp = temp / 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        BackwardNum backwardNumm = new BackwardNum();
        int res = backwardNumm.getDigital(123);
        System.out.println(res);
    }
}
