import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        long answer = 0;
        int currentTime = 0;
        int[] time = new int[n];
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            // time[i] = health[i] / power + (health[i] % power > 0 ? 1 : 0)
            time[i] = (health[i] + power - 1) / power;
        }

        for (int i = 0; i < n; ++i) {
            indices.add(i);
        }

        indices.sort((a, b) -> time[a] * damage[b] - time[b] * damage[a]);

        for (int index : indices) {
            currentTime += time[index];
            answer += (long) currentTime * damage[index];
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int power = scanner.nextInt();
           int n = scanner.nextInt();
           int[] damage = new int[n];
           for (int i = 0; i < n; ++i) {
               damage[i] = scanner.nextInt();
           }
           int[] health = new int[n];
           for (int i = 0; i < n; ++i) {
               health[i] = scanner.nextInt();
           }

           System.out.println(new Solution().minDamage(power, damage, health));
       }
       
       scanner.close();
   }
}
