import java.util.*;

class Solution {
    public int findLeastNumOfUniqueInts(int[] nums, int k) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> !Objects.equals(a.get(1), b.get(1)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0));
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : count.keySet()) {
            pq.add(new ArrayList<>(Arrays.asList(num, count.get(num))));
        }

        while (k > 0) {
            ArrayList<Integer> numAndCount = pq.poll();
            assert numAndCount != null;
            int num = numAndCount.get(0);
            int cnt = numAndCount.get(1);
            if (k >= cnt) {
                k -= cnt;
            } else {
                k = 0;
                pq.add(new ArrayList<>(Arrays.asList(num, cnt - k)));
            }
        }

        return pq.size();
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
            System.out.println(solution.findLeastNumOfUniqueInts(nums, k));
        }

        sc.close();
    }
}
