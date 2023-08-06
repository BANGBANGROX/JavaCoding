import java.util.*;

class Solution {
    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, ArrayList<Integer>> numIndexes = new HashMap<>();
        int answer = Integer.MAX_VALUE;
        int n = nums.size();

        for (int i = 0; i < n; ++i) {
            numIndexes.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }

        for (int num : numIndexes.keySet()) {
            numIndexes.get(num).add(numIndexes.get(num).get(0) + n);
            int result = 0;
            for (int i = 1; i < numIndexes.get(num).size(); ++i) {
                result = Math.max(result, (numIndexes.get(num).get(i) - numIndexes.get(num).get(i - 1)) / 2);
            }
            answer = Math.min(answer, result);
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
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                nums.add(x);
            }

            Solution solution = new Solution();
            System.out.println(solution.minimumSeconds(nums));
        }

        sc.close();
    }
}
