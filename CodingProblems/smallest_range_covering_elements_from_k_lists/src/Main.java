import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int maxVal = Integer.MIN_VALUE;
        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;
        int k = nums.size();

        for (int i = 0; i < k; ++i) {
            int val = nums.get(i).getFirst();
            maxVal = Math.max(maxVal, val);
            pq.add(new int[]{val, i, 0});
        }

        while (pq.size() == k) {
            int[] data = pq.poll();
            assert data != null;
            int minVal = data[0];
            int row = data[1];
            int col = data[2];
            if (maxVal - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = maxVal;
            }
            if (col + 1 < nums.get(row).size()) {
                int nextVal = nums.get(row).get(col + 1);
                maxVal = Math.max(maxVal, nextVal);
                pq.add(new int[]{nextVal, row, col + 1});
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int k = scanner.nextInt();
           List<List<Integer>> nums = new ArrayList<>();

           for (int i = 0; i < k; ++i) {
               List<Integer> currentRow = new ArrayList<>();
               int size = scanner.nextInt();
               for (int j = 0; j < size; ++j) {
                   currentRow.add(scanner.nextInt());
               }
               nums.add(new ArrayList<>(currentRow));
           }

           int[] answer = new Solution().smallestRange(nums);
           System.out.println(answer[0] + " " + answer[1]);
       }
       
       scanner.close();
   }
}
