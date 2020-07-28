package site.zhguixin.algo.trick;

public class Number {

    // // 一个无序的数组, 找出超过一半的数字
    // 方案一: 直接排序这个无序数组, 那么中间那个数字就是超过一半的数字
    // 方案二: O(N)时间复杂度, 定义两个变量分别指向当前数字, 和该数字出现的次数, 遍历时如果出现的数字与变量指向的数字不相等，次数减一, 否则次数加一
    public int getMoreThanHalfNum(int[] nums) {
        int tempNum = nums[0], times = 1;

        for (int i = 1; i < nums.length;i++) {
            if (nums[i] == tempNum) {
                times++;
            } else {
                times--;
                if (times == 0) {// 次数减为0, 重新赋值为当前数, 次数计为1
                    tempNum = nums[i];
                    times = 1;
                }
            }
        }
        return tempNum;
    }

    // 一个含有正负数字的的有序数组, 求对每个元素平方后, 有多少个不同的结果
    // 思路:双指针前后遍历, 绝对值大的向中间移动
    public int getDifferentNum(int[] nums) {
        int i = 0, j = nums.length - 1;
        int larger = Integer.MAX_VALUE;// 记录绝对值大的数字
        int count = 0;

        while (i < j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                i++;
            } else if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                j--;
            } else {
                i++;
                j--;
            }
            count++;
        }
        return count;
    }

    // 将一个十进制数转换为二进制数
    public String printBinary(int num) {
        StringBuilder str = new StringBuilder();
        int temp = num;
        while (temp > 0) {
            str.append(temp%2);
            temp = temp/2;
        }
        // 需要逆置一下
        return str.reverse().toString();
    }


    public static void main(String[] args) {
        Number number = new Number();
        int[] nums = {3,3,1,1,5,5,5,5,5};
        int res = number.getMoreThanHalfNum(nums);
        System.out.println("res=" + res);

        int[] nums2 = {-5,-3,2,1,3,3,5};
        int diffCount = number.getDifferentNum(nums2);
        System.out.println("diffCount=" + diffCount);
    }
}
