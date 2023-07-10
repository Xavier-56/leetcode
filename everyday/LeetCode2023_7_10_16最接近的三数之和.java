package everyday;

import java.util.Arrays;

public class LeetCode2023_7_10_16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left != right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                } else if (sum > target) {
                    right--;
                } else left++;
            }
        }
        return result;
    }
}