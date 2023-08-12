import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        Set<Integer> answer = new HashSet<>();
        Set<Integer> current = new HashSet<>();

        current.add(0);

        for (int x : nums) {
            Set<Integer> current2 = new HashSet<>();
            for (int y : current) {
                current2.add(x | y);
            }
            current2.add(x);
            current = current2;
            answer.addAll(current2);
        }

        return answer.size();
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
            System.out.println(solution.subarrayBitwiseORs(nums));
        }

        sc.close();
    }
}
