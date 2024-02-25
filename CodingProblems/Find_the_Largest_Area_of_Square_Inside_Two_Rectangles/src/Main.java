import java.util.Scanner;

class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long answer = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
               int minX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
               int maxX = Math.min(topRight[i][0], topRight[j][0]);
               int minY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
               int maxY = Math.min(topRight[i][1], topRight[j][1]);
               if (minX < maxX && minY < maxY) {
                   int side = Math.min(maxX - minX, maxY - minY);
                   answer = Math.max(answer, (long) side * side);
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
            int[][] bottomLeft = new int[n][2];
            for (int i = 0; i < n; ++i) {
                bottomLeft[i][0] = sc.nextInt();
                bottomLeft[i][1] = sc.nextInt();
            }
            int[][] topRight = new int[n][2];
            for (int i = 0; i < n; ++i) {
                topRight[i][0] = sc.nextInt();
                topRight[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.largestSquareArea(bottomLeft, topRight));
        }

        sc.close();
    }
}
