import java.util.Scanner;

class Solution {
    public int maxOperations(String s) {
        int onesCount = s.charAt(0) == '1' ? 1 : 0;
        int answer = 0;
        int n = s.length();

        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) == '1') {
                answer += onesCount;
            }
            if (s.charAt(i) == '1') {
                ++onesCount;
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
            System.out.println(new Solution().maxOperations(scanner.next()));
        }

        scanner.close();
    }
}
