package everyday;

public class LeetCode2023_1_24_1828统计一个圆中点的数目 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int m = points.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int queryX = queries[i][0];
            int queryY = queries[i][1];
            int queryR = queries[i][2];
            for (int j = 0; j < m; j++) {
                int pointX = points[j][0];
                int pointY = points[j][1];
                if (Math.pow(queryX - pointX, 2) + Math.pow(queryY - pointY, 2) <= Math.pow(queryR, 2)) {
                    ++answer[i];
                }
            }
        }
        return answer;
    }
}
