import java.util.Scanner;

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        int n = queries.length;
        int[] ans = new int[n];

        for (int num: nums) {
            if ((num & 1) == 0) evenSum += num;
        }

        for (int i = 0; i < n; ++i) {
            int[] q = queries[i];
            int index = q[0];
            int val = q[1];
            int prevValue = nums[index];
            nums[index] += val;
            if ((prevValue & 1) == 0) {
                if ((nums[index] & 1) == 0) evenSum += val;
                else evenSum -= prevValue;
            }
            else {
                if ((nums[index] & 1) == 0) evenSum += nums[index];
            }
            ans[i] = evenSum;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[][] queries = new int[m][2];
            for (int i = 0; i < m; ++i) {
                queries[i][0] = sc.nextInt();
                queries[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.sumEvenAfterQueries(nums, queries);
            for (int x: ans) {
                System.out.println(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
