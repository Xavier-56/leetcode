package everyday;

import java.util.ArrayList;

/**
 *木桶效应的题目
 *分别统统计s和target中各个字母的个数用l1、l2表示
 *l1[i]/l2[i]的最小值即为答案
 */
public class LeetCode2023_1_13_2287重排字符形成目标字符串 {
    public int rearrangeCharacters(String s, String target) {
        int[] l1 = new int[26];
        int[] l2 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++l1[s.charAt(i) - 'a'];
        }
        for (int i = 0; i < target.length(); i++) {
            ++l2[target.charAt(i) - 'a'];
        }
        for (int i=0;i<26;i++){
            if (l1[i]<l2[i]) return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (l2[i] == 0) continue;
            else result = Math.min(result, l1[i] / l2[i]);
        }
        return result;
    }
}
