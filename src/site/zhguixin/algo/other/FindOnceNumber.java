package site.zhguixin.algo.other;

public class FindOnceNumber {

    // 一个整数数组, 只有一个数字出现了一次,其他数字出现两次,找到这个数字
    public int getOnceNum(int[] nums) {
        int res = nums[0];

        for (int i = 1; i < nums.length;i++) {
            res = res^nums[i];
        }
        return res;
    }

    // 一个整数数组, 只有两个数字出现了一次, 其他数字出现两次,找到这两个数字
    public int getNum(int[] nums) {
        int res1 = 0, res2 = 0;
        int res = getOnceNum(nums);

        int i = 0;
        // 找到一个bit为1的, 按照这个位置是否为1, 将原数组分组为两组
        while (((res>>i) & 1) != 0) {
            i++;
        }

        for (int num : nums) {
            if ((num >> i) != 0) {
                res1 = res1^num;
            } else {
                res2 = res2^num;
            }
        }
        return res;
    }

    // 在一个数组中, 有一个数字只出现了一次, 其他数字出现了三次, 求出这个数字
    // 技巧: 数组中的每一个bit为按十进制相加得到的值再与3求余, 那些出现三次的求余后都为0了
    public int findNum(int[] nums) {
        int[] bitInt = new int[32];

        for (int i = 0; i <32;i++) {
            for (int j = 0; j <nums.length;j++) {
                bitInt[i] += (nums[j] >> i);
            }
        }

        int result = 0;
        for (int i = 0; i <32;i++) {
            result |= ((bitInt[i] % 3) << i);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
//        int[] nums = {3,3,5,1,1};
        int[] nums = {3,3,3,1,5,5,5};
        FindOnceNumber findOnceNumber = new FindOnceNumber();
        int res = findOnceNumber.findNum(nums);
        System.out.print("res=" + res);
    }
}
