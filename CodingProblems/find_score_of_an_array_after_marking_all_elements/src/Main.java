import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private static class Element {
        int index;
        int val;

        Element(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    public long findScore(int[] nums) {
        long answer = 0;
        int n = nums.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val != b.val ?
                a.val - b.val : a.index - b.index);

        for (int i = 0; i < n; ++i) {
            pq.add(new Element(i, nums[i]));
        }

        while (!pq.isEmpty()) {
            Element element = pq.poll();
            if (visited[element.index]) continue;
            answer += element.val;
            if (element.index > 0) {
                visited[element.index - 1] = true;
            }
            if (element.index < n - 1) {
                visited[element.index + 1] = true;
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] nums = new int[n];
           for (int i = 0; i < n; ++i) {
               nums[i] = scanner.nextInt();
           }

           System.out.println(new Solution().findScore(nums));
       }
       
       scanner.close();
   }
}
