import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> mp = new HashMap<>();
        int ans = 0;

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                mp.put(num1 + num2, mp.getOrDefault(num1 + num2, 0) + 1);
            }
        }

        for (int num3 : nums3) {
            for (int num4 : nums4) {
                ans += mp.getOrDefault(-1 * (num3 + num4), 0);
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
            int[] nums1 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums1[i] = sc.nextInt();
            }
            int[] nums2 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums2[i] = sc.nextInt();
            }
            int[] nums3 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums3[i] = sc.nextInt();
            }
            int[] nums4 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums4[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.fourSumCount(nums1, nums2, nums3, nums4));
        }

        sc.close();
    }
}
