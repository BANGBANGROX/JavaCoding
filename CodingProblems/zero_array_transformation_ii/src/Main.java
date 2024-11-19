import java.util.Scanner;

class Solution {
    private int[] nums;
    private int[][] queries;
    private int n;

    private boolean check(int queryCnt) {
        int[] impact = new int[n + 1];

        for (int i = 0; i < queryCnt; ++i) {
            int left = queries[i][0];
            int right = queries[i][1];
            int val = queries[i][2];
            impact[left] += val;
            impact[right + 1] -= val;
        }

        for (int i = 1; i <= n; ++i) {
            impact[i] += impact[i - 1];
        }

        for (int i = 0; i < n; ++i) {
            if (impact[i] < nums[i]) return false;
        }

        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        this.nums = nums;
        this.queries = queries;
        n = nums.length;
        int left = 0;
        int right = queries.length;
        int answer = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (check(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           int q = scanner.nextInt();
           int[][] queries = new int[q][3];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
               queries[i][2] = scanner.nextInt();
           }

           System.out.println(new Solution().minZeroArray(nums, queries));
       }
       
       scanner.close();
   }
}
