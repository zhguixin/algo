package site.zhguixin.algo.dp;

public class JumpGame {

    // 在数组中跳跃, 判断能否跳跃到最后一个位置, 即nums[len -1]
    public boolean canJumpToEnd(int[] nums) {
        return false;
    }

    // 贪心算法
    // 在数组中跳跃, 所需最小的跳跃步数
    public int getMinJumpSetps(int[] nums) {
        int farthest = 0;
        int end = 0;//标记最远位置
        int setps = 0;
        for (int i = 0;i < nums.length -1;i++) {
            farthest = Math.max(farthest, i + nums[i]);
            // end 是否达到最远位置, 从最远的位置开始跳跃, 步数加一
            if (i == end) {
                setps++;
                end = farthest;
            }
        }
        return setps;
    }
}
