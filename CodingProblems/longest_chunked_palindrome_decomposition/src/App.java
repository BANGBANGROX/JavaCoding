import java.util.Scanner;

class Solution {
    public int longestDecomposition(String text) {
        String left = "";
        String right = "";
        int n = text.length();
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            left += text.charAt(i);
            right = text.charAt(n - i - 1) + right;
            if (left.equals(right)) {
                ++answer;
                left = "";
                right = "";
            }
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().longestDecomposition(scanner.next()));
        }

        scanner.close();
    }
}
