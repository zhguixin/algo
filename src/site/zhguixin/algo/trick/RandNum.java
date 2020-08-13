package site.zhguixin.algo.trick;

// 给定一个randA可以等概率的出现1~5，实现randB等概率出现1~25

// 给你一个能生成1到5随机数的函数，用它写一个函数生成1到7的随机数
// https://www.cnblogs.com/fisherinbox/p/6559346.html
public class RandNum {

    public int rand25() {

        int res = (rand5() - 1) * 5 + rand5();
        return 0;
    }

    // 只要要求的随机数发生器小于给定的随机发生器，都可以通过while循环取得大随机数产生的随机数小于给定的值
    public int rand7() {
        int res = Integer.MAX_VALUE;
        // 要产生随机数1~7，只要产生的随机数大于7,不符合结果, 继续执行
        while (res > 7) {
            res = rand25();
        }
        return res;
    }

    // 上一个随机数生成器在rand25之上产生rand7, 舍弃了很多, 为了尽可能低的舍弃数目
    // 可以考虑对rand25产生的数对7求余
    public int rand7Pro() {
        int res = Integer.MAX_VALUE;
        while (res > 21) {
            res = rand25();
        }
        return res%7 + 1;
    }

    public int rand5() {
        return 0;
    }

}
