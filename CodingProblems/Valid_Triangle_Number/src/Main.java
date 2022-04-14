import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;

        if (n < 3) return 0;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; ++i) {
            // We consider 3 edges
            // a = nums[i]
            // b = nums[i+1] or nums[j]
            // c = nums[i+2] or nums[k]
            int k = i + 2;
            for (int j = i + 1; j < n - 1 && nums[i] != 0; ++j) {
                while (k < n && nums[k] < nums[i] + nums[j]) ++k;
                ans += (k - (j + 1));
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
            System.out.println(solution.triangleNumber(nums));
        }

        sc.close();
    }
}
