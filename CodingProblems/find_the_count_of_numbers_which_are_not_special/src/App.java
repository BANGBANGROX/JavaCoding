import java.util.Scanner;

class Solution {
    private boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) return false;
        }

        return true;
    }

    public int nonSpecialCount(int l, int r) {
        int answer = r - l + 1;

        for (int i = (int) Math.ceil(Math.sqrt(l)); i <= (int) Math.floor(Math.sqrt(r)); ++i) {
            if (isPrime(i)) {
                --answer;
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
            System.out.println(new Solution().nonSpecialCount(scanner.nextInt(), scanner.nextInt()));
        }

        scanner.close();
    }
}
