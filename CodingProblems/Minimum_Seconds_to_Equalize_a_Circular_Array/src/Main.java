import java.util.*;

class Solution {
    private int justGreater(ArrayList<Integer> list, int key) {
        int n = list.size();
        int l = 0;
        int r = n - 1;
        int result = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (list.get(mid) <= key) {
                l = mid + 1;
            }
            else {
                result = mid;
                r = mid - 1;
            }
        }

        return result;
    }

    private int justSmaller(ArrayList<Integer> list, int key) {
        int n = list.size();
        int l = 0;
        int r = n - 1;
        int result = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (list.get(mid) >= key) {
                r = mid - 1;
            }
            else {
                result = mid;
                l = mid + 1;
            }
        }

        return result;
    }

    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, ArrayList<Integer>> numIndexes = new HashMap<>();
        int n = nums.size();
        int mode = nums.get(0);
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            int num = nums.get(i);
            if (!numIndexes.containsKey(num)) {
                numIndexes.put(num, new ArrayList<>());
            }
            numIndexes.get(num).add(i);
        }

        for (int num : numIndexes.keySet()) {
            if (numIndexes.get(num).size() > numIndexes.get(mode).size()) {
                mode = num;
            }
        }

        if (numIndexes.get(mode).size() == 1) {
            return n / 2;
        }

        for (int i = 0; i < n; ++i) {
            if (nums.get(i) == mode) {
                continue;
            }
            int smallerIndex = justSmaller(numIndexes.get(mode), i);
            int greaterIndex = justGreater(numIndexes.get(mode), i);
            int result = 0;
            if (smallerIndex == -1) {
                result = Math.max(result, numIndexes.get(mode).get(greaterIndex) - i);
            }
            else if (greaterIndex == -1) {
                result = Math.max(result, i - numIndexes.get(mode).get(smallerIndex));
            }
            else {
                result = Math.max(result, Math.min(numIndexes.get(mode).get(greaterIndex) - i,
                        i - numIndexes.get(mode).get(smallerIndex)));
            }
            int last = numIndexes.get(mode).get(numIndexes.get(mode).size() - 1);
            int first = numIndexes.get(mode).get(0);
            if (last > i) {
                result = Math.min(result, n - last + i);
            }
            if (first < i) {
                result = Math.min(result, first + n - i);
            }
            answer = Math.max(answer, result);
        }

        return answer;
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
