import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        int i = m - 2;
        int j = n - 2;
        int horizontalPieces = 1;
        int verticalPieces = 1;
        long answer = 0;

        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        while (i >= 0 && j >= 0) {
            if (horizontalCut[i] > verticalCut[j]) {
                answer += 1L * horizontalCut[i] * verticalPieces;
                --i;
                ++horizontalPieces;
            } else {
                answer += 1L * verticalCut[j] * horizontalPieces;
                --j;
                ++verticalPieces;
            }
        }

        while (i >= 0) {
            answer += 1L * horizontalCut[i] * verticalPieces;
            --i;
            ++horizontalPieces;
        }

        while (j >= 0) {
            answer += 1L * verticalCut[j] * horizontalPieces;
            --j;
            ++verticalPieces;
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] horizontalCut = new int[m - 1];
            for (int i = 0; i < m - 1; ++i) {
                horizontalCut[i] = scanner.nextInt();
            }
            int[] verticalCut = new int[n - 1];
            for (int i = 0; i < n - 1; ++i) {
                verticalCut[i] = scanner.nextInt();
            }

            System.out.println(new Solution().minimumCost(m, n, horizontalCut, verticalCut));
        }

        scanner.close();
    }
}
