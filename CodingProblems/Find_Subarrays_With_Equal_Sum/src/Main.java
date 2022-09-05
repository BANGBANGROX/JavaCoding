import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        int n = nums.length;
        int l = 0;
        int r = 1;
        int sum = nums[l] + nums[r];


        while (r < n) {
            if (visited.contains(sum)) return true;
            visited.add(sum);
            sum -= nums[l];
            ++l;
            ++r;
            if (r < n) sum += nums[r];
        }

        return false;
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
            System.out.println(solution.findSubarrays(nums));
        }

        sc.close();
    }
}
