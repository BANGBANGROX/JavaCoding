import java.util.Scanner;

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
         int n = chalk.length;
         long sum = 0;

         for (int x : chalk) {
             sum += x;
         }

         k %= sum;

         for (int i = 0; i < n; ++i) {
             if (chalk[i] > k) return i;
         }

         return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] chalk = new int[n];
            for (int i = 0; i < n; ++i) {
                chalk[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.chalkReplacer(chalk, k));
        }

        sc.close();
    }
}
