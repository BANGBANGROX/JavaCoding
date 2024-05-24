import java.util.*;

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer>> modNums = new HashMap<>();
        int answer = 1;

        Arrays.sort(nums);

        for (int num : nums) {
            modNums.computeIfAbsent(num % k, x -> new ArrayList<>()).add(num);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : modNums.entrySet()) {
            ArrayList<Integer> currentNums = entry.getValue();
            TreeMap<Integer, Integer> count = new TreeMap<>();
            for (int x : currentNums) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
            int prevNotTaken = 1;
            int prevTaken = 0;
            int lastValue = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> countEntry : count.entrySet()) {
                int val = countEntry.getKey();
                int cnt = countEntry.getValue();
                int currentSubsets = (1 << cnt) - 1;
                int nowTaken;
                int nowNotTaken = prevNotTaken + prevTaken;
                if (lastValue + k == val) {
                    nowTaken = prevNotTaken * currentSubsets;
                }
                else {
                    nowTaken = (prevNotTaken + prevTaken) * currentSubsets;
                }
                prevNotTaken = nowNotTaken;
                prevTaken = nowTaken;
                lastValue = val;
            }
            answer *= (prevTaken + prevNotTaken);
        }

        return answer - 1;
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

            Solution solution = new Solution();
            System.out.println(solution.beautifulSubsets(nums, k));
        }

        sc.close();
    }
}
