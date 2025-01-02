import java.util.Scanner;

class Solution {
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int q = queries.length;
        int n = words.length;
        int[] prefix = new int[n];
        int[] answer = new int[q];

        prefix[0] = (isVowel(words[0].charAt(0)) &&
                isVowel((words[0].charAt(words[0].length() - 1))) ? 1 : 0);

        for (int i = 1; i < n; ++i) {
            prefix[i] = prefix[i - 1] + (isVowel(words[i].charAt(0)) &&
                    isVowel(words[i].charAt(words[i].length() - 1)) ? 1 : 0);
        }

        for (int i = 0; i < q; ++i) {
            int left = queries[i][0];
            int right = queries[i][1];
            answer[i] = (prefix[right] - (left > 0 ? prefix[left - 1] : 0));
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
           int q = scanner.nextInt();
           int[][] queries = new int[q][2];
           for (int i = 0; i < q; ++i) {
               queries[i][0] = scanner.nextInt();
               queries[i][1] = scanner.nextInt();
           }

           int[] answer = new Solution().vowelStrings(words, queries);
           for (int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
