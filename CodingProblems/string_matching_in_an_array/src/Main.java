import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j) {
                    if (words[j].contains(words[i])) {
                        answer.add(words[i]);
                        break;
                    }
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
           int n = scanner.nextInt();
           String[] words = new String[n];
           for (int i = 0; i < n; ++i) {
               words[i] = scanner.next();
           }

           System.out.println(new Solution().stringMatching(words));
       }
       
       scanner.close();
   }
}
