import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        int currentSum = 0;
        int answer = 0;

        for (int x : banned) {
            bannedSet.add(x);
        }

        for (int i = 1; i <= n; ++i) {
            if (!bannedSet.contains(i) && currentSum + i <= maxSum) {
                currentSum += i;
                ++answer;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int m = scanner.nextInt();
           int[] banned = new int[m];
           for (int i = 0; i < m; ++i) {
               banned[i] = scanner.nextInt();
           }
           int n = scanner.nextInt();
           int maxSum = scanner.nextInt();

           System.out.println(new Solution().maxCount(banned, n, maxSum));
       }
       
       scanner.close();
   }
}
