import java.util.Scanner;

class Solution {
    public String getHint(String secret, String guess) {
        int n = secret.length();
        int bulls = 0;
        int cows = 0;
        int[] frequency = new int[10];
        String ans;

        for (int i = 0; i < n; ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
                continue;
            }
            ++frequency[secret.charAt(i) - '0'];
        }

        for (int i = 0; i < n; ++i) {
            if (secret.charAt(i) == guess.charAt(i)) continue;
            if (frequency[guess.charAt(i) - '0'] > 0) {
                ++cows;
                --frequency[guess.charAt(i) - '0'];
            }
        }

        ans = bulls + "A" + cows + "B";

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String secret = sc.next();
            String guess = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.getHint(secret, guess));
        }

        sc.close();
    }
}
