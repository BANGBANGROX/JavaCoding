import java.util.Scanner;

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
         int n = values.length, ans = Integer.MIN_VALUE;
         int[] aux = new int[n];

         aux[n - 1] = values[n - 1] - (n - 1);

         for (int i = n - 2; i >= 0; --i) {
             aux[i] = Math.max(aux[i + 1], values[i] - i);
         }

         for (int i = 0; i < n - 1; ++i) {
             ans = Math.max(ans, values[i] + i + aux[i + 1]);
         }

         return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; ++i) {
                values[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            System.out.println(obj.maxScoreSightseeingPair(values));
        }

        sc.close();
    }
}
