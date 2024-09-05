import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sumOfMRolls = Arrays.stream(rolls).sum();
        int sumOfNRolls = mean * (m + n) - sumOfMRolls;

        if (sumOfNRolls < n || sumOfNRolls > 6 * n) return new int[]{};

        int[] answer = new int[n];
        int val = sumOfNRolls / n;

        for (int i = 0; i < n - 1; ++i) {
            answer[i] = val;
            sumOfNRolls -= val;
        }

        if (sumOfNRolls <= 6) {
            answer[n - 1] = sumOfNRolls;
        } else {
            answer[n - 1] = val;
            sumOfNRolls -= val;
            for (int i = 0; i < n && sumOfNRolls > 0; ++i) {
                ++answer[i];
                --sumOfNRolls;
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
           int[] rolls = new int[m];
           for (int i = 0; i < m; ++i) {
               rolls[i] = scanner.nextInt();
           }
           int mean = scanner.nextInt();
           int n = scanner.nextInt();

           int[] answer = new Solution().missingRolls(rolls, mean, n);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
