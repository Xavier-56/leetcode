package everyday;

public class LeetCode2023_2_15_1250检查好数组 {
    public boolean isGoodArray(int[] nums) {
        int result = nums[0];
        for (int num : nums) {
            result = gcd(result, num);
            if (result == 1) break;
        }
        return result == 1;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
