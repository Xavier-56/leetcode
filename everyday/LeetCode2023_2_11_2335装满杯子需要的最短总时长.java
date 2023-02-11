package everyday;

import java.util.Arrays;

public class LeetCode2023_2_11_2335装满杯子需要的最短总时长 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[2] > amount[0] + amount[1]) {
            return amount[2];
        } else return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }
}
