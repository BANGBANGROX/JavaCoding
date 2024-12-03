import java.util.Scanner;

class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder answer = new StringBuilder();
        int itr = 0;
        int n = s.length();
        int totalSpaces = spaces.length;

        for (int i = 0; i < n; ++i) {
            if (itr < totalSpaces) {
                if (i == spaces[itr]) {
                    answer.append(" ");
                    ++itr;
                }
            }
            answer.append(s.charAt(i));
        }

        return answer.toString();
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           String s = scanner.next();
           int n = scanner.nextInt();
           int[] spaces = new int[n];
           for (int i = 0; i < n; ++i) {
               spaces[i] = scanner.nextInt();
           }

           System.out.println(new Solution().addSpaces(s, spaces));
       }
       
       scanner.close();
   }
}
