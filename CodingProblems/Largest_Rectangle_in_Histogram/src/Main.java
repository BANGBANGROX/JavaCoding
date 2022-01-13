import java.util.Scanner;
import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
         int n = heights.length;
         int i = 0;
         int maxArea = 0;
         Stack<Integer> st = new Stack<>();

         while (i < n) {
             if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                 st.push(i);
                 ++i;
                 continue;
             }
             int top = st.peek();
             st.pop();
             int currentHeight = heights[top];
             int width = (i - (!st.isEmpty() ? st.peek() + 1 : 0));
             maxArea = Math.max(maxArea, currentHeight * width);
         }

         while (!st.isEmpty()) {
             int top = st.peek();
             st.pop();
             int currentHeight = heights[top];
             int width = (i - (!st.isEmpty() ? st.peek() + 1 : 0));
             maxArea = Math.max(maxArea, currentHeight * width);
         }

         return maxArea;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] heights = new int[n];
            for (int i = 0; i < n; ++i) {
                heights[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.largestRectangleArea(heights));
        }

        sc.close();
    }
}
