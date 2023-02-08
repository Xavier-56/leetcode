package everyday;

import java.util.*;

public class LeetCode2023_2_8_1233删除子文件夹 {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, folder);
        List<String> result = new ArrayList<>();
        for (String f : folder) {
            boolean existFolder = false;
            for (int i = 1; i < f.length(); i++) {
                if (f.charAt(i) == '/') {
                    String parentFolder = f.substring(0, i);
                    if (set.contains(parentFolder)) {
                        existFolder = true;
                        break;
                    }
                }
            }
            if (!existFolder) {
                result.add(f);
            }
        }
        return result;
    }
}
