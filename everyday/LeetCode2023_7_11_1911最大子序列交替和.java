package everyday;

public class LeetCode2023_7_11_1911最大子序列交替和 {
    public long maxAlternatingSum(int[] nums) {
        long even = nums[0], odd = 0;
        for (int i = 1; i < nums.length; i++) {
            even = Math.max(even, odd + nums[i]);
            odd = Math.max(odd, even - nums[i]);
        }
        return even;
    }
}
