package everyday;

import java.util.Arrays;

public class LeetCode2023_7_4_2679矩阵中的和 {
    public int matrixSum(int[][] nums) {
        for (int[] row : nums) {
            Arrays.sort(row);
        }
        int ans = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int max = 0;
            for (int[] row : nums) {
                max = Math.max(max, row[i]);
            }
            ans += max;
        }
        return ans;
    }
}
