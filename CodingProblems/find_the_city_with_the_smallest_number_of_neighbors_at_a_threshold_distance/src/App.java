import java.util.Scanner;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        int requiredCity = -1;
        int connectedCityCnt = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int[] edge : edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE && distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            int currentCnt = 0;
            for (int j = 0; j < n; ++j) {
                if (distance[i][j] <= distanceThreshold) {
                    ++currentCnt;
                    if (currentCnt > connectedCityCnt) {
                        break;
                    }
                }
            }
            if (currentCnt <= connectedCityCnt) {
                requiredCity = i;
                connectedCityCnt = currentCnt;
            }
        }

        return requiredCity;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int edgesCnt = scanner.nextInt();
            int[][] edges = new int[edgesCnt][3];
            for (int i = 0; i < edgesCnt; ++i) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
                edges[i][2] = scanner.nextInt();
            }
            int distanceThreshold = scanner.nextInt();

            System.out.println(new Solution().findTheCity(n, edges, distanceThreshold));
        }

        scanner.close();
    }
}
