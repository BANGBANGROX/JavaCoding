import java.util.Scanner;

class Solution {
    public boolean checkIfPangram(String sentence) {
         boolean[] visited = new boolean[26];

         for (char ch : sentence.toCharArray()) {
             visited[ch - 'a'] = true;
         }

         for (int i = 0; i < 26; ++i) {
             if (!visited[i]) return false;
         }

         return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String sentence = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.checkIfPangram(sentence));
        }

        sc.close();
    }
}
