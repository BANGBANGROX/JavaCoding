import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int answer = 0;

        for (int num : nums) {
            pq.add((long) num);
        }

        while (pq.size() > 1 && pq.peek() < k) {
            long val1 = pq.poll();
            long val2 = pq.poll();
            pq.add(Math.min(val1, val2) * 2 + Math.max(val1, val2));
            ++answer;
        }

        return answer;
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

           System.out.println(new Solution().minOperations(nums, k));
       }
       
       scanner.close();
   }
}
