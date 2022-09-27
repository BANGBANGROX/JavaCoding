import java.util.ArrayList;
import java.util.Scanner;

class Solution {
    private int lowerBound(ArrayList<Integer> nums, int key) {
        int l = 0;
        int r = nums.size() - 1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (nums.get(mid) < key) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ArrayList<ArrayList<Integer>> bitsIndex = new ArrayList<>();

        for (int bit = 0; bit < 32; ++bit) {
            ArrayList<Integer> current = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) > 0) current.add(i);
            }
            bitsIndex.add(new ArrayList<>(current));
        }

        for (int i = 0; i < n; ++i) {
            int idx = i;
            for (int bit = 0; bit < 32; ++bit) {
                if (bitsIndex.get(bit).isEmpty()) continue;
                int ind = lowerBound(bitsIndex.get(bit), i);
                if (ind == bitsIndex.get(bit).size()) continue;
                idx = Math.max(idx, bitsIndex.get(bit).get(ind));
            }
            ans[i] = (idx - i + 1);
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
            int[] ans = solution.smallestSubarrays(nums);
            for (int x: ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
