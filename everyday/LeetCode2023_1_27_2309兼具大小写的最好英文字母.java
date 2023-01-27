package everyday;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2023_1_27_2309兼具大小写的最好英文字母 {
    public String greatestLetter(String s) {
        Map<Integer, Character> letter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letter.put(i, c);
        }
        for (int i = 25; i >= 0; i--) {
            if (letter.containsValue((char) ('a' + i)) && letter.containsValue((char) ('A' + i))) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}
