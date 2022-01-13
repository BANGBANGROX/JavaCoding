import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
         StringBuilder ans = new StringBuilder();
         List<Integer> unused = new ArrayList<>();
         int[] fact = new int[n + 1];

         fact[0] = 1;

         for (int i = 1; i <= n; ++i) {
             unused.add(i);
             fact[i] = fact[i - 1] * i;
         }

         --k;

         while (n > 0) {
             int partLength = fact[n] / n;
             int part = k / partLength;
             ans.append(unused.get(part));
             unused.remove(part);
             --n;
             k = k % partLength;
         }

         return ans.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.getPermutation(n, k));
        }

        sc.close();
    }
}
