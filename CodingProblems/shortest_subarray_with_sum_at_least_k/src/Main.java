import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int answer = Integer.MAX_VALUE;
        long[] prefixSum = new long[n];
        Deque<Integer> indices = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            prefixSum[i] = nums[i] + (i > 0 ? prefixSum[i - 1] : 0);
        }

        for (int i = 0; i < n; ++i) {
            if (prefixSum[i] >= k) {
                answer = Math.min(answer, i + 1);
            }
            while (!indices.isEmpty() && prefixSum[i] - prefixSum[indices.getFirst()] >= k) {
                answer = Math.min(answer, i - indices.pollFirst());
            }
            while (!indices.isEmpty() && prefixSum[i] <= prefixSum[indices.getLast()]) {
                indices.pollLast();
            }
            indices.offerLast(i);
        }

        return answer != Integer.MAX_VALUE ? answer : -1;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           int k = scanner.nextInt();

           System.out.println(new Solution().shortestSubarray(nums, k));
       }
       
       scanner.close();
   }
}
