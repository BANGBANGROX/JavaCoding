import java.util.Scanner;

class Solution {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1 : 0.5;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            System.out.println(new Solution().nthPersonGetsNthSeat(scanner.nextInt()));
        }

        scanner.close();
    }
}
