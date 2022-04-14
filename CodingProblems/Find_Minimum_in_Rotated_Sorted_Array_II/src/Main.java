import java.util.Scanner;

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        if (nums[l] < nums[r]) return nums[l];

        while (l < r) {
            int mid = (l + ((r - l) >> 1));
            System.out.println(l + " " + mid + " " + r);
            if (nums[r] == nums[mid]) {
                --r;
            }
            else if (nums[r] > nums[mid]) r = mid;
            else l = mid + 1;
            System.out.println(l + " " + mid + " " + r);
        }

        System.out.println(l);

        return nums[l];
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
            System.out.println(solution.findMin(nums));
        }

        sc.close();
    }
}
