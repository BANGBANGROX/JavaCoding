import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -1 * a));
        long answer = 0;

        for (int gift : gifts) {
            pq.add(gift);
        }

        while (!pq.isEmpty() && k > 0) {
            int val = pq.poll();
            int remaining = (int) Math.floor(Math.sqrt(val));
            if (remaining > 0) {
                pq.add(remaining);
            }
            --k;
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
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
           int[] gifts = new int[n];
           for (int i = 0; i < n; ++i) {
               gifts[i] = scanner.nextInt();
           }
           int k = scanner.nextInt();

           System.out.println(new Solution().pickGifts(gifts, k));
       }
       
       scanner.close();
   }
}
