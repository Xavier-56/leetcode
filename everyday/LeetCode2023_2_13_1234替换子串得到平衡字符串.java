package everyday;

public class LeetCode2023_2_13_1234替换子串得到平衡字符串 {
    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }
        int n = s.length() / 4;
        int result = s.length();
        if (check(cnt, n)) {
            return 0;
        }
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, n)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, n)) {
                break;
            }
            result = Math.min(result, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return result;
    }

    private boolean check(int[] cnt, int n) {
        if (cnt[idx('Q')] > n || cnt[idx('W')] > n || cnt[idx('E')] > n || cnt[idx('R')] > n) {
            return false;
        }
        return true;
    }

    private int idx(char c) {
        return c - 'A';
    }
}
