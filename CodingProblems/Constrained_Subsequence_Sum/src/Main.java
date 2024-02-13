import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            nums[i] += (!linkedList.isEmpty() ? nums[linkedList.getFirst()] : 0);
            while (!linkedList.isEmpty() && (i - linkedList.getFirst() >= k ||
                    nums[i] >= nums[linkedList.getLast()])) {
                if (nums[i] >= nums[linkedList.getLast()]) linkedList.pollLast();
                else linkedList.pollFirst();
            }
            if (nums[i] > 0) linkedList.add(i);
        }

        assert n > 0;

        return Arrays.stream(nums).max().getAsInt();
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
            System.out.println(solution.constrainedSubsetSum(nums, k));
        }

        sc.close();
    }
}
