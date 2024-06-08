import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int maximumLength(int[] nums, int k) {
        int answer = 1;
        int[] maxSizeForCnt = new int[k + 1];
        ArrayList<HashMap<Integer, Integer>> maxSizeForNum = new ArrayList<>();

        for (int i = 0; i <= k; ++i) {
            maxSizeForNum.add(new HashMap<>());
        }

        for (int num : nums) {
            for (int j = k; j >= 0; --j) {
                int current = 1;
                if (maxSizeForNum.get(j).containsKey(num)) {
                    current = Math.max(current, maxSizeForNum.get(j).get(num) + 1);
                }
                if (j > 0) {
                    current = Math.max(current, maxSizeForCnt[j - 1] + 1);
                }
                maxSizeForNum.get(j).put(num, Math.max(maxSizeForNum.get(j).getOrDefault(num, 0), current));
                maxSizeForCnt[j] = Math.max(maxSizeForCnt[j], current);
                answer = Math.max(answer, current);
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
            int k = sc.nextInt();

            System.out.println(new Solution().maximumLength(nums, k));
        }

        sc.close();
    }
}
