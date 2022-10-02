import java.util.Scanner;

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if ((m & 1) == 0 && (n & 1) == 0) return 0;

        int xr1= 0;
        int xr2 = 0;

        for (int x: nums1) xr1 ^= x;

        for (int x: nums2) xr2 ^= x;

        if ((m & 1) > 0 && (n & 1) > 0) return xr1 ^ xr2;

        if ((m & 1) == 0) return xr1;

        return xr2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int[] nums1 = new int[m];
            for (int i = 0; i < m; ++i) {
                nums1[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            int[] nums2 = new int[n];
            for (int i = 0; i < n; ++i) {
                nums2[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.xorAllNums(nums1, nums2));
        }

        sc.close();
    }
}
