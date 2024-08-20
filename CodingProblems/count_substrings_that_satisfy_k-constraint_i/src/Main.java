import java.util.Scanner;

class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int answer = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            int onesCnt = 0;
            int zeroesCnt = 0;
            for (int j = i; j < n; ++j) {
                if (s.charAt(j) == '0') {
                    ++zeroesCnt;
                } else {
                    ++onesCnt;
                }
                if (onesCnt <= k || zeroesCnt <= k) {
                    ++answer;
                }
                else {
                    break;
                }
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
           System.out.println(new Solution().countKConstraintSubstrings(scanner.next(),
                   scanner.nextInt()));
       }
   }
}
