import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int numRabbits(final int[] answers) {
        final Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;

        for (final int val : answers) {
            count.put(val, count.getOrDefault(val, 0) + 1);
        }

        for (final Map.Entry<Integer, Integer> entry : count.entrySet()) {
            answer += (int) Math.ceil((double) entry.getValue() / (entry.getKey() + 1)) * (entry.getKey() + 1);
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] answers = new int[n];
           for (int i = 0; i < n; ++i) {
               answers[i] = scanner.nextInt();
           }

           System.out.println(new Solution().numRabbits(answers));
       }
       
       scanner.close();
   }
}
