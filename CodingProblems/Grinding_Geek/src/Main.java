//{ Driver Code Starts

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int total = scanner.nextInt();
            int[] cost = new int[n];
            for (int i = 0; i < n; i++) {
                cost[i] = scanner.nextInt();
            }
            Solution solution = new Solution();
            int result = solution.max_courses(n, total, cost);
            System.out.println(result);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    private int[][] dp;
    private int[] cost;
    private int n;

    private int maxCoursesHandler(int idx, int total) {
        if (idx >= n) return 0;

        if (dp[idx][total] != -1) return dp[idx][total];

        int answer = maxCoursesHandler(idx + 1, total);

        if (total >= cost[idx]) {
            answer = Math.max(answer, maxCoursesHandler(idx + 1, total - cost[idx] + (int)(0.9 * cost[idx])) + 1);
        }

        return dp[idx][total] = answer;
    }

    public int max_courses(int n, int total, int[] cost) {
        // code here
        dp = new int[n][total + 1];
        this.cost = cost;
        this.n = n;

        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }

        return maxCoursesHandler(0, total);
    }
}

