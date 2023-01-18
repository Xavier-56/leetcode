import java.util.HashMap;
import java.util.Map;

/**
 * 此题可以用暴力做法双层循环去比较是否满足题目要求，但时间复杂度过高。
 * 将题目所给公式nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 转换成 nums[i] - rev(nums[i]) === nums[j] - rev(nums[j])
 * 这样等式的左边和右边都分别只有一个索引，可以用新的数组newNums来存储 nums[i] - rev(nums[i])。
 * 利用哈希表计数，找出nums[i] === num[j]的数对，累加得到结果
 */
public class LeetCode2023_1_17_1814统计一个数组中好对子的数目 {
    public int countNicePairs(int[] nums) {
        int MOD = (int) (1e9 + 7);
        int result = 0;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < newNums.length; i++) {
            newNums[i] = nums[i] - rev(nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < newNums.length; i++) {
            result = (result + map.getOrDefault(newNums[i], 0) % MOD)%MOD;
            map.put(newNums[i], map.getOrDefault(newNums[i], 0) + 1);
        }
        return result;
    }

    public int rev(int num) {
        int a = 0;
        while (num != 0) {
            a = a * 10 + (num % 10);
            num = num / 10;
        }
        return a;
    }
}
