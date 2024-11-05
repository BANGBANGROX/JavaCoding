import java.util.Scanner;

class Solution {
    public int minChanges(String s) {
        int answer = 0;
        char last = s.charAt(0);
        int n = s.length();

        for (int i = 1; i < n; ++i) {
            if (last == '#') {
                last = s.charAt(i);
            } else {
                if (s.charAt(i) != last) {
                    ++answer;
                }
                last = '#';
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
           System.out.println(new Solution().minChanges(scanner.next()));
       }
       
       scanner.close();
   }
}
