import java.util.*;

public class LeetCode2023_1_12_1807替换字符串中的括号内容 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        String[] s1 = s.split("\\)");
        for (int i = 0; i < s1.length; i++) {
            if (s1[i].contains("(")) {
                int index = s1[i].indexOf("(");
                int len = s1[i].length();
                String key = s1[i].substring(index + 1, len);
                StringBuilder sb = new StringBuilder(s1[i]);
                if (map.containsKey(key)) {
                    sb.replace(index, len, map.get(key));
                } else {
                    sb.replace(index, len, "?");
                }
                s1[i] = String.valueOf(sb);
            } else {
                continue;
            }
        }
        String result = String.join("", s1);
        return result;
    }
}