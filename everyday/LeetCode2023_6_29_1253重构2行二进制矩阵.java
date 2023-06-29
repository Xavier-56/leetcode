package everyday;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2023_6_29_1253重构2行二进制矩阵 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0, len = colsum.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < len; i ++){
            sum += colsum[i];
        }
        if(upper + lower != sum){
            return list;
        }
        List<Integer> upl = new ArrayList<>();
        List<Integer> lol = new ArrayList<>();
        for(int i = 0; i < len; i ++){
            if(colsum[i] == 2){
                upl.add(1);
                lol.add(1);
                upper --;
                lower --;
            }
            else if(colsum[i] == 0){
                upl.add(0);
                lol.add(0);
            }
            else {
                if(upper > lower){
                    upl.add(1);
                    lol.add(0);
                    upper --;
                }
                else {
                    lol.add(1);
                    upl.add(0);
                    lower --;
                }
            }
            if(upper < 0 || lower < 0){
                return list;
            }
        }
        list.add(upl);
        list.add(lol);
        return list;
    }
}
