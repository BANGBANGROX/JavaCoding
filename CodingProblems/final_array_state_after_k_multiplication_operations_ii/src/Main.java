import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private final int MOD = (int) 1e9 + 7;

    private static class Pair {
        long first;
        int second;

        Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int binaryExponentiation(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = (result * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return (int) result;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }

        int n = nums.length;

        assert n > 0;

        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[] answer = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.first < b.first) return -1;
            if (a.first > b.first) return 1;
            return a.second - b.second;
        });

        for (int i = 0; i < n; ++i) {
            pq.add(new Pair(nums[i], i));
        }

        while (k > 0 && !pq.isEmpty() && pq.peek().first * multiplier <= maxValue) {
            Pair minPair = pq.poll();
            pq.add(new Pair(minPair.first * multiplier, minPair.second));
            --k;
        }

        if (k == 0) {
            while (!pq.isEmpty()) {
                Pair pair = pq.poll();
                answer[pair.second] = (int) (pair.first % MOD);
            }

            return answer;
        }

        int extraOperations = k - (k / n * n);

        while (extraOperations > 0 && !pq.isEmpty()) {
            Pair minPair = pq.poll();
            pq.add(new Pair(minPair.first * multiplier, minPair.second));
            --extraOperations;
        }

        k -= extraOperations;
        int operationsPerIndex = k / n;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            pair.first %= MOD;
            int power = binaryExponentiation(multiplier, operationsPerIndex);
            System.out.println(pair.first + " " + power);
            int val = (int) ((pair.first * power) % MOD);
            answer[pair.second] = val;
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           int k = scanner.nextInt();
           int multiplier = scanner.nextInt();

           int[] answer = new Solution().getFinalState(nums, k, multiplier);
           for (int x : answer) {
               System.out.println(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
