import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int[][][] dp;
    private int[] rating;
    private int n;

    private int numTeamsHandler(int lastPickedIndex, int currentIndex, int currentPickCnt) {
        if (currentPickCnt == 3) {
            return 1;
        }

        if (currentIndex >= n) {
            return 0;
        }

        if (dp[lastPickedIndex][currentIndex][currentPickCnt] != -1) {
            return dp[lastPickedIndex][currentIndex][currentPickCnt];
        }

        return dp[lastPickedIndex][currentIndex][currentPickCnt] = numTeamsHandler(lastPickedIndex, currentIndex + 1,
                currentPickCnt)
                + (rating[currentIndex] > rating[lastPickedIndex]
                        ? numTeamsHandler(currentIndex, currentIndex + 1, currentPickCnt + 1)
                        : 0);
    }

    private void reverse(int[] rating) {
        int left = 0;
        int right = rating.length - 1;

        while (left < right) {
            int temp = rating[left];
            rating[left] = rating[right];
            rating[right] = temp;
            ++left;
            --right;
        }
    }

    private int computeResult(int[] rating) {
        dp = new int[n][n][3];
        int result = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for (int i = 0; i < rating.length; ++i) {
            result += numTeamsHandler(i, i + 1, 1);
        }

        return result;
    }

    public int numTeams(int[] rating) {
        this.rating = rating.clone();
        n = rating.length;
        dp = new int[n][n][3];
        int answer = 0;

        answer += computeResult(rating);

        reverse(rating);
        this.rating = rating;

        answer += computeResult(rating);

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] rating = new int[n];
            for (int i = 0; i < n; ++i) {
                rating[i] = scanner.nextInt();
            }

            System.out.println(new Solution().numTeams(rating));
        }

        scanner.close();
    }
}
