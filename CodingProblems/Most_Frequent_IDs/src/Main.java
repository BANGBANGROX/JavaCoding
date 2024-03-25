import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int n = nums.length;
        long[] answer = new long[n];
        HashMap<Integer, Long> count = new HashMap<>();
        TreeSet<Integer> ordering = new TreeSet<>((a, b) -> !Objects.equals(count.getOrDefault(b, 0L), count.getOrDefault(a, 0L)) ? (int) (count.getOrDefault(b, 0L) - count.getOrDefault(a, 0L)) : !Objects.equals(a, b) ? a - b : 0);

        for (int i = 0; i < n; ++i) {
            int id = nums[i];
            int cntChange = freq[i];
            ordering.remove(id);
            count.put(id, count.getOrDefault(id, 0L) + cntChange);
            ordering.add(id);
            answer[i] = count.get(ordering.first());
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
            int[] freq = new int[n];
            for (int i = 0; i < n; ++i) {
                freq[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            long[] answer = solution.mostFrequentIDs(nums, freq);
            for (long x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
