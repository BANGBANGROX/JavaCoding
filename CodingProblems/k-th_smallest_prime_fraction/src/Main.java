import java.util.*;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] nums, int k) {
        int n = nums.length;
        double left = 0;
        double right = 1;

        while (left <= right) {
            double mid = (left + ((right - left)) / 2);
            double maxFraction = 0;
            int totalFractionsLessThan = 0;
            int j = 1;
            int numerator = -1;
            int denominator = -1;
            for (int i = 0; i < n; ++i) {
                while (j < n && nums[i] >= nums[j] * mid) {
                    ++j;
                }
                totalFractionsLessThan += (n - j);
                if (j < n && maxFraction < nums[i] * 1.0 / nums[j]) {
                    maxFraction = nums[i] * 1.0 / nums[j];
                    numerator = i;
                    denominator = j;
                }
            }
            if (totalFractionsLessThan == k) {
                return new int[]{nums[numerator], nums[denominator]};
            }
            if (totalFractionsLessThan > k) {
                right = mid;
            }
            else {
                left = mid;
            }
        }

        return new int[]{-1, -1};
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
            int k = sc.nextInt();

            int[] answer = new Solution().kthSmallestPrimeFraction(nums, k);
            System.out.println(answer[0] + " " + answer[1]);
        }

        sc.close();
    }
}
