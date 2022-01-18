import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map;

class Solution {
    public int longestConsecutive(int[] nums) {
       int maxLength = 0;
       Map<Integer,Boolean> mp = new HashMap<>();
       HashSet<Integer> visited = new HashSet<>();

       for (int num : nums) {
           mp.put(num, true);
       }

       for (int num : nums) {
           if (visited.contains(num)) continue;
           if (!mp.containsKey(num - 1)) {
               int currentLength = 1;
               while (mp.containsKey(num + 1)) {
                   visited.add(num);
                   ++num;
                   ++currentLength;
               }
               maxLength = Math.max(maxLength, currentLength);
           }
       }

       return maxLength;
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
            System.out.println(solution.longestConsecutive(nums));
        }

        sc.close();
    }
}
