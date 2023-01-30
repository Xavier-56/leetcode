package single330;

import java.util.HashMap;
import java.util.Map;

public class Solution6337 {
    Map<Integer, Integer> result = new HashMap<>();
    public int distinctIntegers(int n) {
        result.put(n,n);
        for (int i = 1; i <= n; i++) {
            if (n % i == 1) {
                if (!result.containsValue(i)){
                    result.put(i,i);
                    distinctIntegers(i);
                }
            }
        }
        return result.size();
    }
}
