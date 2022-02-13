import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
      List<List<Integer>> ans = new ArrayList<>();
      Set<List<Integer>> st = new HashSet<>();
      int n = nums.length;

      Arrays.sort(nums);

      for (int i = 0; i < n - 3; ++i) {
          int currentTarget = target - nums[i];
          for (int j = i + 1; j < n - 2; ++j) {
              int requiredSum = currentTarget - nums[j];
              int l = j + 1;
              int r = n - 1;
              while (l < r) {
                  int sum = nums[l] + nums[r];
                  if (sum == requiredSum) {
                      if (!st.contains(Arrays.asList(nums[i], nums[j], nums[l], nums[r]))) {
                          ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                          st.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                      }
                      ++l;
                      --r;
                  }
                  else if (sum > requiredSum) --r;
                  else ++l;
              }
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
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.fourSum(nums, target));
        }

        sc.close();
    }
}
