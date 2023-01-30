package everyday;

public class LeetCode2023_1_29_2315统计星号 {
    public int countAsterisks(String s) {
        String[] spilts = s.split("\\|");
        for (int i = 0; i < spilts.length; i++) {
            if (i % 2 == 1) {
                spilts[i] = "";
            }
        }
        int result = 0;
        String sNow = String.join("", spilts);
        for (int i = 0; i < sNow.length(); i++) {
            if (sNow.charAt(i) == '*') {
                result++;
            }
        }
        return result;
    }
}
