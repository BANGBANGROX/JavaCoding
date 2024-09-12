import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();
        int answer = 0;

        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        for (String word : words) {
            boolean isConsistent = true;

            for (char ch : word.toCharArray()) {
                if (!allowedSet.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }

            if (isConsistent) {
                ++answer;
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
           String allowed = scanner.next();
           int n = scanner.nextInt();
           String[] words = new String[n];
           for (int i = 0; i < n; ++i) {
               words[i] = scanner.next();
           }

           System.out.println(new Solution().countConsistentStrings(allowed, words));
       }
       
       scanner.close();
   }
}
