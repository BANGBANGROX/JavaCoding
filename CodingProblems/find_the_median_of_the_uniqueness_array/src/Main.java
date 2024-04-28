import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private int[] nums;

    private long countAtMostK(int median) {
        int left = 0;
        long cnt = 0;
        HashMap<Integer, Integer> numsCount = new HashMap<>();

        for (int right = 0; right < nums.length; ++right) {
            numsCount.put(nums[right], numsCount.getOrDefault(nums[right], 0) + 1);
            while (numsCount.size() > median) {
                numsCount.put(nums[left], numsCount.get(nums[left]) - 1);
                if (numsCount.get(nums[left]) == 0) {
                    numsCount.remove(nums[left]);
                }
                ++left;
            }
            cnt += (right - left + 1);
        }


        return cnt;
    }

    public int medianOfUniquenessArray(int[] nums) {
        this.nums = nums;
        int length = nums.length;
        long totalSubarrays = (long) length * (length + 1) / 2;
        long target = ((totalSubarrays & 1) > 0 ? (totalSubarrays + 1) / 2 : totalSubarrays / 2);
        int left = 1;
        int right = length;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            long cntAtMostMedian = countAtMostK(mid);
            long cntExactMedian = cntAtMostMedian - countAtMostK(mid - 1);
            long lessThanMedian = cntAtMostMedian - cntExactMedian;
            if (lessThanMedian < target && cntAtMostMedian >= target) return mid;
            else if (cntAtMostMedian < target) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
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

            System.out.println(new Solution().medianOfUniquenessArray(nums));
        }

        sc.close();
    }
}
