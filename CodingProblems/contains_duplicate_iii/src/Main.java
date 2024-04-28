import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        HashMap<Integer, Integer> numInBucket = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int bucketId = getBucketId(nums[i], valueDiff);
            if (numInBucket.containsKey(bucketId)) return true;
            numInBucket.put(bucketId, nums[i]);
            if (numInBucket.containsKey(bucketId - 1) && nums[i] - numInBucket.get(bucketId - 1) <= valueDiff) return true;
            if (numInBucket.containsKey(bucketId + 1) && numInBucket.get(bucketId + 1) - nums[i] <= valueDiff) return true;
            while (numInBucket.size() > indexDiff) {
                int currentBucketId = getBucketId(nums[i - indexDiff], valueDiff);
                numInBucket.remove(currentBucketId);
            }
        }

        return false;
    }

    private int getBucketId(int num, int bucketSize) {
        int bucketId = num / (bucketSize + 1);

        return num < 0 ? bucketId - 1 : bucketId;
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
            int indexDiff = sc.nextInt();
            int valueDiff = sc.nextInt();

            System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
        }

        sc.close();
    }
}
