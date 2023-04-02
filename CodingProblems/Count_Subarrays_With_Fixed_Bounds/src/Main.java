import java.util.Scanner;

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int maxIndex = -1;
        int minIndex = -1;
        int leftBound = -1;
        long ans = 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] > maxK || nums[i] < minK) {
                leftBound = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }
            if (nums[i] == minK) {
                minIndex = i;
            }
            ans += Math.max(0, Math.min(maxIndex, minIndex) - leftBound);
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
            int maxK = sc.nextInt();
            int minK = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countSubarrays(nums, maxK, minK));
        }

        sc.close();
    }
}
