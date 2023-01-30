package single330;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution6338 {
    public int monkeyMove(int n) {
        final int MOD = (int) (1e9 + 7);
        Map<Integer, Integer> next = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!next.containsValue((i + 1) % n)) {
                next.put((i + 1) % n, (i + 1) % n);
            } else if (!next.containsValue((i - 1 + n) % n)) {
                next.put((i - 1 + n) % n, (i - 1 + n) % n);
            }else {
                result++;
            }
        }
        return result % MOD;
    }
}
