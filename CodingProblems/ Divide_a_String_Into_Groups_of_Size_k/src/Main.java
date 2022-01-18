import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public String[] divideString(String s, int k, char fill) {
          int n = s.length();
          int size = (int)Math.ceil((double)n / k);
          int index = 0;
          String[] ans = new String[size];

          for (int i = 0; i < n; ++i) {
              StringBuilder currWord = new StringBuilder();
              while (i < n && currWord.length() < k) {
                  currWord.append(s.charAt(i));
                  ++i;
              }
              ans[index++] = currWord.toString();
              if (i == n) break;
              --i;
          }

          while (ans[size - 1].length() != k) {
              ans[size - 1] += fill;
          }

          return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            char fill = sc.next().charAt(0);

            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.divideString(s, k, fill)));
        }

        sc.close();
    }
}
