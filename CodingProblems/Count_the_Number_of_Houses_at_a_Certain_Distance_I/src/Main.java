import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] distance = new int[n][n];
        final int INF = (int) 1e9;
        int[] answer = new int[n];

        for (int i = 0; i < n; ++i) {
            Arrays.fill(distance[i], INF);
        }

        for (int i = 0; i < n; ++i) {
            if (i + 1 < n) {
                distance[i][i + 1] = 1;
            }
            if (i > 0) {
                distance[i][i - 1] = 1;
            }
        }

        distance[x - 1][y - 1] = distance[y - 1][x - 1] = 1;

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == j) distance[i][j] = 0;
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int dis = 0; dis < n; ++dis) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (distance[i][j] == dis + 1) {
                        ++answer[dis];
                    }
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            Solution solution = new Solution();
            int[] answer = solution.countOfPairs(n, x, y);
            for (int res : answer) {
                System.out.print(res);
            }
            System.out.println();
        }

        sc.close();
    }
}
