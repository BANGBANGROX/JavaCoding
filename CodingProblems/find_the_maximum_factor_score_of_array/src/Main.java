import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private final int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    private Map<Integer, Integer> primeFactorization(int num) {
        Map<Integer, Integer> result = new HashMap<>();

        for (int primeNumber : primeNumbers) {
            result.put(primeNumber, 0);
        }

        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                int cnt = 0;
                while (num % i == 0) {
                    ++cnt;
                    num /= i;
                }
                result.put(i, cnt);
            }
        }

        if (num > 1) {
            result.put(num, 1);
        }

        return result;
    }

    private long binaryExponentiation(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = result * a;
            }
            a = a * a;
            b >>= 1;
        }

        return result;
    }

    private long maxScoreHandler(List<Integer> nums) {
        Map<Integer, Integer> minPower = new HashMap<>();
        Map<Integer, Integer> maxPower = new HashMap<>();
        long result = 1;

        for (int num : nums) {
            Map<Integer, Integer> currentPrimeFactorization = primeFactorization(num);
            for (Map.Entry<Integer, Integer> entry : currentPrimeFactorization.entrySet()) {
                int primeFactor = entry.getKey();
                int power = entry.getValue();
                if (minPower.containsKey(primeFactor)) {
                    minPower.put(primeFactor, Math.min(power, minPower.get(primeFactor)));
                } else {
                    minPower.put(primeFactor, power);
                }
                if (maxPower.containsKey(primeFactor)) {
                    maxPower.put(primeFactor, Math.max(power, maxPower.get(primeFactor)));
                } else {
                    maxPower.put(primeFactor, power);
                }
            }
        }

        for (int prime : primeNumbers) {
            int totalPower = minPower.getOrDefault(prime, 0) +
                    maxPower.getOrDefault(prime, 0);
            result = (result * binaryExponentiation(prime, totalPower));
        }

        return result;
    }

    public long maxScore(int[] nums) {
        List<Integer> numsList = new ArrayList<>();

        for (int num : nums) {
            numsList.add(num);
        }

        long answer = maxScoreHandler(numsList);

        for (int i = 0; i < nums.length; ++i) {
            numsList = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if (i != j) {
                    numsList.add(nums[j]);
                }
            }
            answer = Math.max(answer, maxScoreHandler(numsList));
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

           System.out.println(new Solution().maxScore(nums));
       }
       
       scanner.close();
   }
}
