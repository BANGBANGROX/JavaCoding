import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minOperations(int[] nums) {
        int answer = Integer.MAX_VALUE;
        int l = 1;
        int n = nums.length;
        int[] dupNums = new int[n];
        int dup = 0;

        Arrays.sort(nums);

        for (int r = 0; r < n; ++r) {
            while (l < n && nums[l] <= (nums[r] + n - 1)) {
                if (nums[l] == nums[l - 1]) ++dup;
                dupNums[l] = dup;
                ++l;
            }
            answer = Math.min(answer, r + n - l + dup - dupNums[r]);
        }

        return answer;
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
            System.out.println(solution.minOperations(nums));
        }

        sc.close();
    }
}
