package everyday;
/**
 * 如果多个数之和为batchSize的倍数，那么这多个数就可以视为一组
 * 题目转换为：对数组进行排序，求解最多的组数
 */

import java.util.HashMap;
import java.util.Map;

public class Leetcode2023_1_22_1815得到新鲜甜甜圈的最多组数 {
    int batchSize;
    Map<Long, Integer> map = new HashMap<>();
    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        int res = 0;
        long state = 0L;
        for(int group : groups) {
            int x = group % batchSize;
            if(x == 0) {
                res++;
            } else {
                state += (1L << (x * 5));
            }
        }
        return res + dfs(state, 0);
    }
    public int dfs(long state, int mod) {
        if(map.containsKey(state)) {
            return map.get(state);
        }
        int res = 0;
        for(int i = 1; i < batchSize; i++) {
            if((state >> (i * 5) & 31) != 0) {
                int cnt = dfs(state - (1L << (i * 5)), (mod + i) % batchSize);
                res = Math.max(res, cnt + (mod == 0 ? 1 : 0));
            }
        }
        map.put(state, res);
        return res;
    }
}
