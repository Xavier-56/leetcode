package everyday;

import java.util.Arrays;

/**
 * 终于有我最爱的动态规划了
 * 设f[i][j]表示青蛙到达i号点的j号跑道时所需要的最少侧跳次数。
 * 初始时，青蛙处于0号点的1号跑道，因此初始化d[0][1]=0,d[0][0]与d[0][2]为1。
 * 对于i从1到n的每个位置，我们可以枚举青蛙当前所处的跑道j，如果obstacles[i]=j+1，说明第j条跑道上有障碍，此时f[i][j]的值为INF；
 * 青蛙可以通过消耗一次侧跳次数从点i处的其他跑道跳到当前跑道。我们设x=min(f[i][0],f[i][1],f[i][2])然后尝试用x来更新每个f[i][j]。
 * 动态转移方程f[i][j]=min(f[i-1][j],x+1)。
 * 转移完成后min(f[n-1][0],f[n-1][1],f[n-1][2])就是答案。
 */
public class LeetCode2023_1_21_1824最小侧跳次数 {
    public int minSideJumps(int[] obstacles) {
        final int INF = 0xfffff;
        int n = obstacles.length;
        int x = INF;
        int[][] f = new int[n][3];
        f[0][0] = 1;
        f[0][2] = 1;
        f[0][1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    f[i][j] = INF;
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
            x = Math.min(f[i][0], Math.min(f[i][1], f[i][2]));
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] != j + 1) {
                    f[i][j] = Math.min(f[i - 1][j], x + 1);
                }
            }
        }
        return Math.min(f[n - 1][0], Math.min(f[n - 1][1], f[n - 1][2]));
    }
}
