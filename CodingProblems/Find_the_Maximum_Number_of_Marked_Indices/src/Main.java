import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        int l = 0;
        int ans = 0;
        int n = nums.length;

        Arrays.sort(nums);

        for (int r = n / 2; r < n; ++r) {
            if (2 * nums[l] <= nums[r]) {
                ++l;
                ans += 2;
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
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxNumOfMarkedIndices(nums));
        }

        sc.close();
    }
}
