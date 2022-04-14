import java.util.*;

class Solution {
    public List<Integer> findClosestElements(int[] nums, int k, int x) {
         List<Integer> ans = new ArrayList<>();
         PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> (
                 !Objects.equals(b.get(0), a.get(0)) ? b.get(0) - a.get(0) : b.get(1) - a.get(1)));

         for (int num : nums) {
             int absoluteValue = Math.abs(x - num);
             if (pq.size() < k) pq.add(new ArrayList<>(Arrays.asList(absoluteValue, num)));
             else {
                 ArrayList<Integer> top = pq.peek();
                 assert top != null;
                 if (absoluteValue <= top.get(0)) {
                     if (absoluteValue < top.get(0) || top.get(1) > num) {
                         pq.poll();
                         pq.add(new ArrayList<>(Arrays.asList(absoluteValue, num)));
                     }
                 }
             }
         }

         while (!pq.isEmpty()) {
             ans.add(pq.peek().get(1));
             pq.poll();
         }

         Collections.sort(ans);

         return ans;
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
            int x = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.findClosestElements(nums, k, x));
        }

        sc.close();
    }
}
