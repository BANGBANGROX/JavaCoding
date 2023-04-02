import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        int maxCount = 0;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            maxCount = Math.max(maxCount, count.get(num));
        }

        for (int i = 0; i < maxCount; ++i) {
            ans.add(new ArrayList<>());
        }

        for (int num : count.keySet()) {
            int cnt = count.get(num);
            for (int i = 0; i < cnt; ++i) {
                ans.get(i).add(num);
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
