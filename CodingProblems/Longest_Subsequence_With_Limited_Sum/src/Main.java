import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int m = queries.length;
        int[] ans = new int[m];

        Arrays.sort(nums);

        for (int i = 0; i < m; ++i) {
            int q = queries[i];
            int sum = 0;
            int j = 0;
            while (j < nums.length && sum <= q) {
                sum += nums[j];
                ++j;
            }
            ans[i] = sum > q ? j - 1 : j;
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
            int[] queries = new int[m];
            for (int i = 0; i < m; ++i) {
                queries[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] ans = solution.answerQueries(nums, queries);
            for (int x: ans) System.out.print(x + " ");
            System.out.println();
        }

        sc.close();
    }
}
