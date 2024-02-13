import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int answer = 0;

        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        for (int alicePoint = 0; alicePoint < n; ++alicePoint) {
            for (int bobPoint = alicePoint + 1; bobPoint < n; ++bobPoint) {
                if (points[bobPoint][1] > points[alicePoint][1]) continue;
                int a = points[alicePoint][0];
                int b = points[bobPoint][0];
                int p = points[alicePoint][1];
                int q = points[bobPoint][1];
                boolean pointBetweenFound = false;
                for (int i = 0; i < n; ++i) {
                    if (i == alicePoint || i == bobPoint) continue;
                    if (points[i][0] >= a && points[i][0] <= b && points[i][1] <= p && points[i][1] >= q) {
                        pointBetweenFound = true;
                        break;
                    }
                }
                if (!pointBetweenFound) {
                    ++answer;
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
            int[][] points = new int[n][2];
            for (int i = 0; i < n; ++i) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.numberOfPairs(points));
        }

        sc.close();
    }
}
