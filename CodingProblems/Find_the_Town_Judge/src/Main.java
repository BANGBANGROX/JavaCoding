import java.util.Scanner;

class Solution {
    public int findJudge(int n, int[][] trust) {
         int[] inDegree = new int[n + 1];
         int[] outDegree = new int[n + 1];
         int judge = -1;

        for (int[] ints : trust) {
            int a = ints[0];
            int b = ints[1];
            ++inDegree[b];
            ++outDegree[a];
        }

         for (int i = 1; i <= n; ++i) {
             if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                 if (judge != -1) return -1;
                 judge = i;
             }
         }

         return judge;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] trust = new int[m][2];
            for (int i = 0; i < m; ++i) {
                trust[i][0] = sc.nextInt();
                trust[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            System.out.println(obj.findJudge(n, trust));
        }

        sc.close();
    }
}
