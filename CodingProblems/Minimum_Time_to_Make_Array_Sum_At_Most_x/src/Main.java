import java.util.*;

class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        final int n = nums1.size();
        int firstSum = 0;
        int secondSum = 0;
        int answer = n + 1;
        int[][] nums2AndNums1 = new int[n][2];
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            firstSum += nums1.get(i);
            secondSum += nums2.get(i);
            nums2AndNums1[i][0] = nums2.get(i);
            nums2AndNums1[i][1] = nums1.get(i);
        }

        if (firstSum <= x) return 0;

        Arrays.sort(nums2AndNums1, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i <= n; ++i) {
            for (int j = Math.min(i, answer); j > 0; --j) {
                dp[j] = Math.max(dp[j], dp[j - 1] +
                        nums2AndNums1[i - 1][0] * j + nums2AndNums1[i - 1][1]);
                if (firstSum + secondSum * j - dp[j] <= x) {
                    answer = j;
                }
            }
        }

        return answer <= n ? answer : -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            List<Integer> nums1 = new ArrayList<>();
            List<Integer> nums2 = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums1.add(x);
            }
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums2.add(x);
            }
            int x = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumTime(nums1, nums2, x));
        }

        sc.close();
    }
}
