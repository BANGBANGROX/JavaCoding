import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int maxResult(int[] nums, int k) {
           int n = nums.length;
           PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));

           pq.add(new ArrayList<>(Arrays.asList(nums[0], 0)));

           for (int i = 1; i < n; ++i) {
               while (!pq.isEmpty() && (i - pq.peek().get(1)) > k) pq.poll();
               assert pq.peek() != null;
               pq.add(new ArrayList<>(Arrays.asList(pq.peek().get(0) + nums[i], i)));
           }

           while (!pq.isEmpty()) {
               if (pq.peek().get(1) == n - 1) return pq.peek().get(0);
               pq.poll();
           }

           return 0;
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
            System.out.println(solution.maxResult(nums, k));
        }

        sc.close();
    }
}
