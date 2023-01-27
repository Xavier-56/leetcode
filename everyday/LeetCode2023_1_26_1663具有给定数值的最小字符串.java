package everyday;

public class LeetCode2023_1_26_1663具有给定数值的最小字符串 {
    public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            if (k - 26 > n - i - 1) {
                result[n - i - 1] = 'z';
                k -= 26;
            } else if (k - 1 == n - 1 - i) {
                result[n - i - 1] = 'a';
                k -= 1;
            } else {
                result[n - i - 1] = (char) ('a' + k - (n - i - 1) - 1);
                k -= k - (n - i - 1);
            }
        }
        return new String(result);
    }
}
