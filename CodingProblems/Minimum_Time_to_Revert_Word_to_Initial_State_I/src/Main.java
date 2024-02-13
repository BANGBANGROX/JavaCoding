import java.util.Scanner;

class Solution {
    private int k;
    private String word;

    private String performOperation(String currentWord) {
        return currentWord.substring(k) + "*".repeat(k);
    }

    private boolean equals(String currentWord) {
        for (int i = 0; i < word.length(); ++i) {
            if (currentWord.charAt(i) != '*' && word.charAt(i) != currentWord.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public int minimumTimeToInitialState(String word, int k) {
        this.k = k;
        this.word = word;
        int answer = 0;
        String currentWord = word;

        do {
            ++answer;
            currentWord = performOperation(currentWord);
        } while (!equals(currentWord));

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String word = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minimumTimeToInitialState(word, k));
        }

        sc.close();
    }
}
