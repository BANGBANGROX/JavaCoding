import java.util.*;

class Solution {
    private final LinkedList<Integer> currentList = new LinkedList<>();
    private final List<List<Integer>> ans = new ArrayList<>();
    private final HashSet<LinkedList<Integer>> visited = new HashSet<>();
    private int n;
    private int[] nums;

    private void findSubsequencesUtil(int index, int previousNum) {
        if (index >= n) {
            if (currentList.size() > 1 && !visited.contains(currentList)) {
                ans.add(new LinkedList<>(currentList));
                visited.add(currentList);
            }
            return;
        }

        findSubsequencesUtil(index + 1, previousNum);

        if (nums[index] >= previousNum) {
            currentList.add(nums[index]);
            findSubsequencesUtil(index + 1, nums[index]);
            currentList.pollLast();
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        n = nums.length;

        findSubsequencesUtil(0, Integer.MIN_VALUE);

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

            Solution solution = new Solution();
            System.out.println(solution.findSubsequences(nums));
        }

        sc.close();
    }
}

