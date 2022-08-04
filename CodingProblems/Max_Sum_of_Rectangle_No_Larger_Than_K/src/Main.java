import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    private int maxSumLessThanEqualToK(int[] nums, int k) {
        int cumSum = 0;
        int ans = Integer.MIN_VALUE;
        TreeSet<Integer> st = new TreeSet<>();

        st.add(0);

        for (int num : nums) {
            cumSum += num;
            if (st.ceiling(cumSum - k) != null) {
                int x = st.ceiling(cumSum - k);
                ans = Math.max(ans, cumSum - x);
            }
            st.add(cumSum);
        }

        return ans;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }

        for (int top = 0; top < m; ++top) {
            for (int bottom = top; bottom < m; ++bottom) {
                int[] nums = new int[n];
                for (int i = 0; i < n; ++i) {
                    nums[i] = (top == 0) ? matrix[bottom][i] : matrix[bottom][i] - matrix[top - 1][i];
                }
                ans = Math.max(ans, maxSumLessThanEqualToK(nums, k));
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.maxSumSubmatrix(matrix, k));
        }

        sc.close();
    }
}
