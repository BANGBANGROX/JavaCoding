import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int numberOfPairs(int[][] points) {
        int answer = 0;
        int n = points.length;

        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1, maxY = Integer.MIN_VALUE; j < n; ++j) {
                if (points[i][1] >= points[j][1] && maxY < points[j][1]) {
                    ++answer;
                    maxY = points[j][1];
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
