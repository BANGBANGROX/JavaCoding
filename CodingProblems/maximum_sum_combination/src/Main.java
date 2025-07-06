import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public ArrayList<Integer> topKSumPairs(final int[] arr1, final int[] arr2, final int k) {
        // code here
        final int n = arr1.length;
        final ArrayList<Integer> answer = new ArrayList<>();
        final PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) -> !Objects.equals(a.getFirst(), b.getFirst()) ? b.getFirst() -
                        a.getFirst() : a.get(1) - b.get(1)
        );
        final Set<List<Integer>> visited = new HashSet<>();

        reverseSort(arr1);
        reverseSort(arr2);

        priorityQueue.add(List.of(arr1[0] + arr2[0], 0, 0));

        while (answer.size() < k && !priorityQueue.isEmpty()) {
            final List<Integer> top = priorityQueue.poll();
            final int sum = top.get(0);
            final int i = top.get(1);
            final int j = top.get(2);
            final List<Integer> first = List.of(i + 1, j);
            final List<Integer> second = List.of(i, j + 1);

            answer.add(sum);

            if (i + 1 < n && visited.add(first)) {
                priorityQueue.add(List.of(arr1[i + 1] + arr2[j], i + 1, j));
            }

            if (j + 1 < n && visited.add(second)) {
                priorityQueue.add(List.of(arr1[i] + arr2[j + 1], i, j + 1));
            }
        }

        return answer;
    }

    private void reverseSort(final int[] arr) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            arr[left] += arr[right];
            arr[right] = arr[left] - arr[right];
            arr[left] = arr[left] - arr[right];
            ++left;
            --right;
        }
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final int[] arr1 = new int[n];
           final int[] arr2 = new int[n];
           for (int i = 0; i < n; ++i) {
               arr1[i] = scanner.nextInt();
           }
           for (int i = 0; i < n; ++i) {
               arr2[i] = scanner.nextInt();
           }
           final int k = scanner.nextInt();

           System.out.println(new Solution().topKSumPairs(arr1, arr2, k));
       }
       
       scanner.close();
   }
}
