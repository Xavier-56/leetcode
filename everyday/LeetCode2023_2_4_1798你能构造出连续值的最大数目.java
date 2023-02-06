package everyday;

import java.util.Arrays;

public class LeetCode2023_2_4_1798你能构造出连续值的最大数目 {
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }
}
