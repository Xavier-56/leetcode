package everyday;

import java.util.HashMap;
import java.util.Map;

/**
 *1.首先遍历数组nums，找出其中最大的数max，之后枚举就只用到这个max即可
 *2.将nums存储到hashmap中
 *3.遍历1~max中的每个正整数，判断map中是否存在一个或多个正整数的最大公约数是i，若是i，count+1。
 *  对于i，只有i的倍数才有可能最大公约是为i，所以j循环每次加i
 *  当map中存在j时，用gcd(gcdNow,j)获取当前最大公约数
 */
public class LeetCode2023_1_14_1819序列中不同最大公约数的数目 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int count = 0;
        for (int i = 1; i <= max; i++) {
            int gcdNow = 0;
            for (int j = i; j <= max; j+=i) {
                if (map.containsKey(j)) {
                    gcdNow = gcd(gcdNow,j);
                }
            }
            if (gcdNow == i) {
                count++;
            }
        }
        return count;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
