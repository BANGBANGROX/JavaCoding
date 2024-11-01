import java.util.Scanner;

class Solution {
    public String makeFancyString(String s) {
        int n = s.length();

        if (n < 3) return s;

        char first = s.charAt(0);
        char second = s.charAt(1);
        StringBuilder answer = new StringBuilder();

        answer.append(first);
        answer.append(second);

        for (int i = 2; i < n; ++i) {
            if (first != second || s.charAt(i) != second) {
                first = second;
                second = s.charAt(i);
                answer.append(s.charAt(i));
            }
        }

        return answer.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().makeFancyString(scanner.next()));
       }
       
       scanner.close();
   }
}
