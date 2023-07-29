import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int left = candidates;
        int right = n - candidates - 1;
        long answer = 0;
        PriorityQueue<Integer> leftPq = new PriorityQueue<>();
        PriorityQueue<Integer> rightPq = new PriorityQueue<>();

        for (int i = 0; i < candidates; ++i) {
            leftPq.add(costs[i]);
        }

        for (int i = Math.max(candidates, n - candidates); i < n; ++i) {
            rightPq.add(costs[i]);
        }

        for (int i = 0; i < k; ++i) {
            if (rightPq.isEmpty() || !leftPq.isEmpty() && leftPq.peek() <= rightPq.peek()) {
                assert leftPq.peek() != null;
                answer += leftPq.poll();
                if (left <= right) {
                    leftPq.add(costs[left]);
                    ++left;
                }
            }
            else {
                answer += rightPq.poll();
                if (left <= right) {
                    rightPq.add(costs[right]);
                    --right;
                }
            }
        }

        return answer;
    }
}

public class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      
      while (T-- > 0) {
          int n = sc.nextInt();
          int[] costs = new int[n];
          for (int i = 0; i < n; ++i) {
              costs[i] = sc.nextInt();
          }
          int k = sc.nextInt();
          int candidates = sc.nextInt();

          Solution solution = new Solution();
          System.out.println(solution.totalCost(costs, k, candidates));
      }
      
      sc.close(); 
  }
}
