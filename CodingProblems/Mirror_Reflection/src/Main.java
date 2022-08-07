import java.util.Scanner;

class Solution {
    public int mirrorReflection(int p, int q) {
          while ((p & 1) == 0 && (q & 1) == 0) {
              p >>= 1;
              q >>= 1;
          }

          return 1 - (p & 1) + (q & 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.mirrorReflection(p, q));
        }

        sc.close();
    }
}
