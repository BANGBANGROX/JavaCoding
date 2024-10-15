import java.util.Scanner;

class Solution {
    public long minimumSteps(String s) {
        long answer = 0;
        int whitePos = 0;
        int n = s.length();

        for (int currentPos = 0; currentPos < n; ++currentPos) {
            if (s.charAt(currentPos) == '0') {
                answer += (currentPos - whitePos);
                ++whitePos;
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
           System.out.println(new Solution().minimumSteps(scanner.next()));
       }
       
       scanner.close();
   }
}
