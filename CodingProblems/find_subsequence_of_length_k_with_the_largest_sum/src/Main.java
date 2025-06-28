import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    public int[] maxSubsequence(final int [] nums, final int k) {
        final PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(
                List::getFirst));
        final List<List<Integer>> finalList = new ArrayList<>();
        final int n = nums.length;

        for (int i = 0; i < n; ++i) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(List.of(nums[i], i));
            } else {
                assert !priorityQueue.isEmpty();
                final List<Integer> top = priorityQueue.poll();
                if (top.getFirst() < nums[i]) {
                    priorityQueue.add(List.of(nums[i], i));
                } else {
                    priorityQueue.add(top);
                }
            }
        }

        while (!priorityQueue.isEmpty()) {
            finalList.add(priorityQueue.poll());
        }

        finalList.sort(Comparator.comparingInt(a -> a.get(1)));

        final int[] answer = new int[k];

        for (int i = 0; i < k; ++i) {
            answer[i] = finalList.get(i).getFirst();
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           final int[] answer = new Solution().maxSubsequence(nums, k);
           for (final int x : answer) {
               System.out.print(x + " ");
           }
           System.out.println();
       }
       
       scanner.close();
   }
}
