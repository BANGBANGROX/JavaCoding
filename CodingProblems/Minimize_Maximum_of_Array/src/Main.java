import java.util.Scanner;

class Solution {
    public int minimizeArrayValue(int[] nums) {
       int n = nums.length;
       long prefixSum = 0;
       int ans = 0;

       for (int i = 0; i < n; ++i) {
           prefixSum += nums[i];
           ans = Math.max(ans, (int)((prefixSum + i) / (i + 1)));
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

            Solution solution = new Solution();
            System.out.println(solution.minimizeArrayValue(nums));
        }

        sc.close();
    }
}
