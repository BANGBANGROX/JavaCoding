//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] asteroids = new int[N];
            for (int i = 0; i < N; i++) asteroids[i] = sc.nextInt();

            Solution obj = new Solution();
            int[] res = obj.asteroidCollision(asteroids);

            for (int e : res) System.out.print(e + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // code here
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean flag = false;
            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                int positiveValue = st.peek();
                int negativeValue = -1 * asteroid;
                if (positiveValue == negativeValue) {
                    st.pop();
                    flag = true;
                    break;
                }
                else if (positiveValue > negativeValue) {
                    flag = true;
                    break;
                }
                else st.pop();
            }
            if (!flag) st.push(asteroid);
        }

        int[] ans = new int[st.size()];
        int idx = st.size() - 1;

        while (!st.isEmpty()) {
            ans[idx] = st.pop();
            --idx;
        }

        return ans;
    }
}
