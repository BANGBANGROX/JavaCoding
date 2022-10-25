import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = n - 3; i >= 0; --i) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            if (c < a + b) return a + b + c;
        }

        return 0;
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
            System.out.println(solution.largestPerimeter(nums));
        }

        sc.close();
    }
}
