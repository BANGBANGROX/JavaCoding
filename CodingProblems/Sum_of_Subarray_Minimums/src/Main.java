import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] nums) {
        long ans = 0;
        final int MOD = (int) 1e9 + 7;
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i <= n; ++i) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] >= nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                long count = (((long) mid - left) * ((long) i - mid)) % MOD;
                ans = (ans + (count * nums[i]) % MOD) % MOD;
            }
            st.push(i);
        }

        return (int) ans;
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

            Solution solution = new Solution();
            System.out.println(solution.sumSubarrayMins(nums));
        }

        sc.close();
    }
}
