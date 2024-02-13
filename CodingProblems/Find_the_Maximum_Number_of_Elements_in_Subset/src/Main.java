import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int maximumLength(int[] nums) {
        assert nums.length > 0;

        HashMap<Integer, Integer> numCount = new HashMap<>();
        int answer = 1;
        int maxNumInArray = Arrays.stream(nums).max().getAsInt();

        for (int num : nums) {
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (numCount.get(num) < 2) continue;
            if (num == 1) {
                answer = Math.max(answer, numCount.get(num) % 2 == 0 ?
                        numCount.get(num) - 1 : numCount.get(num));
                continue;
            }
            for (int k = 2; k <= 16; k *= 2) {
                int tempNum = num;
                int power = 1;
                int result = 0;
                boolean firstHalfComplete = true;
                while (power < k) {
                    if (numCount.getOrDefault(num, 0) < 2) {
                        firstHalfComplete = false;
                        break;
                    }
                    power *= 2;
                    long next = (long) num * num;
                    if (next > maxNumInArray) {
                        firstHalfComplete = false;
                        break;
                    }
                    num = (int) next;
                    ++result;
                }
                if (firstHalfComplete && numCount.containsKey(num)) {
                    answer = Math.max(answer, result * 2 + 1);
                }
                num = tempNum;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maximumLength(nums));
        }

        sc.close();
    }
}
