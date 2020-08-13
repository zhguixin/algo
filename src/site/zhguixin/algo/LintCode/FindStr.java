package site.zhguixin.algo.LintCode;

class FindStr {
    public int firstUniqChar(String s) {
        int[] ch = new int[26];

        char[] str = s.toCharArray();

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i] - 'a');
            ch[str[i] - 'a']++;
        }

        int res = 0;
        for(int i = 0; i < 26;i++) {
            System.out.print(" " + ch[i]);
//            if(ch[i] == 1) {
//                res = i;
//                break;
//            }
        }

        System.out.println(res);
        return res;
    }

    // 乘积最大子数组的积
    // 此种解法无法解决:[-4,2,-5]的情况
    public int getMaxProduct(int[] nums) {
        int max = nums[0], product = nums[0];

        for (int i = 1; i < nums.length; i++) {
            product = Math.max(product * nums[i], nums[i]);
            if (product > max) {
                max = product;
            }
        }
        return max;
    }

    public int getMaxProduct2(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len+1];
        int[] dpMin = new int[len+1];
        dpMax[0] = dpMin[0] = 1;

        for (int i = 1;i <= len;i++) {
            dpMax[i] = max(nums[i-1] * dpMax[i-1], dpMin[i-1] * nums[i-1], nums[i-1]);
            dpMin[i] = min(nums[i-1] * dpMax[i-1], dpMin[i-1] * nums[i-1], nums[i-1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            res = Math.max(res, dpMax[i]);
        }
        return res;
    }

    public int max(int i, int j, int k) {
        return Math.max(Math.max(i, j), k);
    }

    public int min(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }

    public static void main(String[] args) {
        FindStr findStr = new FindStr();
//        findStr.firstUniqChar("leetcode");
        findStr.firstUniqChar("daabbc");

        int[] nums = {-4,2,-5};
        int res = findStr.getMaxProduct2(nums);
        System.out.println(res);
    }
}
