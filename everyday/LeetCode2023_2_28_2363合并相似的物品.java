package everyday;

import java.util.*;

public class LeetCode2023_2_28_2363合并相似的物品 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] item: items1) {
            map.put(item[0], item[1]);
        }
        for (int[] items : items2) {
            Integer orDefault = map.getOrDefault(items[0], 0);
            map.put(items[0], orDefault + items[1]);
        }
        map.forEach((key,value)->{
            res.add(Arrays.asList(key, value));
        });
        return res;
    }
}
