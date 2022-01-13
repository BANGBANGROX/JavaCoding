import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    public int minMoves(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();

        if (k == 1 || n <= 1) return 0;

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) pos.add(i);
        }

        n = pos.size();
        int[] prefix = new int[n];

        prefix[0] = pos.get(0);

        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + pos.get(i);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n - k; ++i) {
            int mid = i + k / 2;
            int right = prefix[i + k - 1] - prefix[mid];
            int left = prefix[mid - 1] - (i > 0 ? prefix[i - 1] : 0);
            int r = (k - 1) / 2;
            int currentAns = right - left + (k % 2 == 0 ? pos.get(mid) : 0) -
                    r * (r + 1) - (k % 2 == 0 ? r + 1 : 0);
            ans = Math.min(ans, currentAns);
        }
        ans = Math.max(ans, 0);

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
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minMoves(nums, k));
        }

        sc.close();
    }
}
