import java.util.Scanner;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = numBottles;
        int remaining = 0;

        while ((numBottles + remaining) >= numExchange) {
            int next = (numBottles + remaining) / numExchange;
            remaining = (numBottles + remaining) % numExchange;
            answer += next;
            numBottles = next;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int numBottles = scanner.nextInt();
            int numExchanges = scanner.nextInt();

            System.out.println(new Solution().numWaterBottles(numBottles, numExchanges));
        }

        scanner.close();
    }
}
