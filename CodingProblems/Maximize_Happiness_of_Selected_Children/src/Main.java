import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long answer = 0;
        int negativeFactor = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int happy : happiness) {
            pq.add(happy);
        }

        while (k > 0) {
            assert pq.size() > 0;
            int val = pq.poll();
            answer += Math.max(val - negativeFactor, 0);
            --k;
            ++negativeFactor;
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
          int[] happiness = new int[n];
          for (int i = 0; i < n; ++i) {
              happiness[i] = sc.nextInt();
          }
          int k = sc.nextInt();

          Solution solution = new Solution();
          System.out.println(solution.maximumHappinessSum(happiness, k));
      }
      
      sc.close(); 
  }
}
