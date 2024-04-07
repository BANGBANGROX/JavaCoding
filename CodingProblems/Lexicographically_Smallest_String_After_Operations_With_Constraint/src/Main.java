import java.util.Scanner;

class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char currentChar = s.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                int gap = Math.min(Math.abs(currentChar - ch), Math.abs(26 - currentChar + ch));
                if (gap <= k) {
                    k -= gap;
                    answer.append(ch);
                    break;
                }
            }
        }

        return answer.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution solution = new Solution();

            System.out.println(solution.getSmallestString(s, k));
        }

        sc.close();
    }
}
