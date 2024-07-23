import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> numsList = new ArrayList<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            numsList.add(num);
        }

        Collections.sort(numsList, (a, b) -> count.get(a) != count.get(b) ? count.get(a) - count.get(b) : b - a);

        return numsList.stream().mapToInt(x -> x).toArray();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
            }

            int[] answer = new Solution().frequencySort(nums);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
