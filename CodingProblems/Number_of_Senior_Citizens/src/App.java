import java.util.Scanner;

class Solution {
    public int countSeniors(String[] details) {
        int answer = 0;

        for (String detail : details) {
            int age = Integer.parseInt(detail.substring(11, 13));
            if (age > 60) {
                ++answer;
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
            int n = scanner.nextInt();
            String[] details = new String[n];
            for (int i = 0; i < n; ++i) {
                details[i] = scanner.next();
            }

            System.out.println(new Solution().countSeniors(details));
        }

        scanner.close();
    }
}
