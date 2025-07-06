import java.util.HashMap;
import java.util.Map;

public class FindSumPairs {
    private final int[] nums1;
    private final int[] nums2;
    private final Map<Integer, Integer> count;

    public FindSumPairs(final int[] nums1, final int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        count = new HashMap<>();

        for (final int num : nums2) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int num = nums2[index];

        nums2[index] += val;

        count.put(num, count.get(num) - 1);
        count.put(num + val, count.getOrDefault(num + val, 0) + 1);
    }

    public int count(int tot) {
        int answer = 0;

        for (final int num : nums1) {
            answer += count.getOrDefault(tot - num, 0);
        }

        return answer;
    }
}