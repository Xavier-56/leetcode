package everyday;

import java.util.Map;

public class LeetCode2023_2_16_2341数组能形成多少数对 {
    public int[] numberOfPairs(int[] nums) {
        int[] sum = new int[101];
        for (int x : nums) {
            sum[x]++;
        }
        int time = 0;
        for (int s : sum) {
            time += s / 2;
        }
        return new int[]{time, nums.length - time * 2};
    }
}
