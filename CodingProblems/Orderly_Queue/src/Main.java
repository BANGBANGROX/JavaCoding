import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public String orderlyQueue(String s, int k) {
          if (k == 1) {
              String ans = s;

              for (int i = 0; i < s.length(); ++i) {
                  String current = s.substring(i) + s.substring(0, i);
                  if (ans.compareTo(current) > 0) ans = current;
              }

              return ans;
          } else {
              char[] arr = s.toCharArray();

              Arrays.sort(arr);
              return new String(arr);
          }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.orderlyQueue(s, k));
        }

        sc.close();
    }
}
