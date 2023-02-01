package everyday;

import java.util.HashMap;
import java.util.Map;

public class LeetCode2023_2_1_2325解密消息 {
    public String decodeMessage(String key, String message) {
        char newRule = 'a';
        Map<Character, Character> rule = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ' && !rule.containsKey(c)) {
                rule.put(c, newRule);
                newRule++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c != ' ') {
                c = rule.get(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
