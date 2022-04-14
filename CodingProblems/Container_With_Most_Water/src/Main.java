import java.util.Scanner;

class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int n = height.length;
        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (height[l] < height[r]) {
                ans = Math.max(ans, height[l] * (r - l));
                ++l;
            }
            else {
                ans = Math.max(ans, height[r] * (r - l));
                --r;
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
            int[] height = new int[n];
            for (int i = 0; i < n; ++i) {
                height[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxArea(height));
        }

        sc.close();
    }
}
