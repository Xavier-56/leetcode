import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 使用哈希表记录一个用户的活跃时刻列表，哈希表的键为用户ID号，相应的哈希表的值为一个set集合，集合中的元素是该ID用户的活跃时刻。
 *
 * 遍历logslogs列表，更新哈希表相应用户ID的活跃时刻列表。最后遍历哈希表.得到结果
 *
 */
public class LeetCode2023_1_20_1817查找用户活跃分钟数 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int result[] = new int[k];
        for (int i = 0; i < logs.length; i++) {
            int user = logs[i][0];
            if (map.containsKey(user)) {
                map.get(user).add(logs[i][1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(logs[i][1]);
                map.put(user, set);
            }
        }
        for (Set<Integer> set : map.values()) {
            ++result[set.size() - 1];
        }
        return result;
    }
}
