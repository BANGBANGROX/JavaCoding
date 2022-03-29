import java.util.*;

class Solution {
    private static class pair {
        int first;
        int second;

        pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    void merge(pair[] numsWithIndexes, int left, int mid, int right, int[] count) {
       int i = left;
       int j = mid + 1;
       int k = 0;
       pair[] temp = new pair[right - left + 1];

       while (i <= mid && j <= right) {
           if (numsWithIndexes[i].first > numsWithIndexes[j].first) {
               temp[k] = numsWithIndexes[i];
               count[numsWithIndexes[i].second] += (right - j + 1);
               ++i;
           }
           else {
               temp[k] = numsWithIndexes[j];
               ++j;
           }
           ++k;
       }

       while (i <= mid) {
           temp[k] = numsWithIndexes[i];
           ++i;
           ++k;
       }

       while (j <= right) {
           temp[k] = numsWithIndexes[j];
           ++j;
           ++k;
       }

       System.arraycopy(temp, 0, numsWithIndexes, left, right + 1 - left);
    }

    private void mergeSort(int left, int right, pair[] numsWithIndexes, int[] count) {
        if (left >= right) return;

        int mid = (left + ((right - left) >> 1));

        mergeSort(left, mid, numsWithIndexes, count);
        mergeSort(mid + 1, right, numsWithIndexes, count);

        merge(numsWithIndexes, left, mid, right, count);
    }

    public List<Integer> countSmaller(int[] nums) {
         int n = nums.length;
         pair[] numsWithIndexes = new pair[n];
         int[] count = new int[n];
         List<Integer> ans = new ArrayList<>();

         for (int i = 0; i < n; ++i) {
             numsWithIndexes[i] = new pair(nums[i], i);
         }

         mergeSort(0, n - 1, numsWithIndexes, count);

         for (int cnt : count) {
             ans.add(cnt);
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

            Solution solution = new Solution();
            System.out.println(solution.countSmaller(nums));
        }

        sc.close();
    }
}
