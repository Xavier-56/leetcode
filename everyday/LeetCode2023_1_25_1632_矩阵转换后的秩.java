package everyday;

import java.util.Arrays;

public class LeetCode2023_1_25_1632_矩阵转换后的秩 {

    int[] p;
    int[] vals;
    Integer[] indexs;
    public int find(int x) {
        if (x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    public void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb)
            p[pb] = pa;
    }
    public int[][] matrixRankTransform(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        p = new int[row * col];
        vals = new int[row * col];
        indexs = new Integer[row * col];
        for (int i = 0; i < row * col; i++) {
            indexs[i] = i;
            p[i] = i;
        }
        Arrays.sort(indexs, (Integer i, Integer j) -> (matrix[i / col][i % col] - matrix[j / col][j % col]));
        int[] rowMaxRank = new int[row];
        int[] colMaxRank = new int[col];
        Arrays.fill(rowMaxRank, -1);
        Arrays.fill(colMaxRank, -1);
        int pos = 0;
        while (pos < row * col) {
            int val = 1;
            int idx = indexs[pos];
            int i = idx / col;
            int j = idx % col;
            if (rowMaxRank[i] != -1) {
                int k = rowMaxRank[i];
                int tmpIdx = i * col + k;
                int tmpLeader = find(tmpIdx);
                int tmpVal = vals[tmpLeader];
                if (matrix[i][j] == matrix[i][k]) {
                    union(idx, tmpIdx);
                    val = tmpVal;
                } else {
                    val = tmpVal + 1;
                }
            }
            if (colMaxRank[j] != -1) {
                int k = colMaxRank[j];
                int tmpIdx = k * col + j;
                int tmpLeader = find(tmpIdx);
                int tmpVal = vals[tmpLeader];
                if (matrix[i][j] == matrix[k][j]) {
                    union(idx, tmpIdx);
                    val = Math.max(val, tmpVal);
                } else {
                    val = Math.max(val, tmpVal + 1);
                }
            }
            rowMaxRank[i] = j;
            colMaxRank[j] = i;
            int leader = find(idx);
            vals[leader] = val;
            pos++;
        }
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int idx = i * col + j;
                res[i][j] = vals[find(idx)];
            }
        }
        return res;
    }
}
