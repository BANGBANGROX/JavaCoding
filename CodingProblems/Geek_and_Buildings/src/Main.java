//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());


            int[] heights = IntArray.input(br, n);

            Solution obj = new Solution();
            long res = obj.maximum_energy(n, heights);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public long maximum_energy(int n, int[] heights) {
        // code here
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];

        result[n - 1] = heights[n - 1];
        st.push(n - 1);

        for (int i = n - 2; i >= 0; --i) {
            while (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                st.pop();
            }
            result[i] = (st.isEmpty() ? heights[i] : heights[i] ^ result[st.peek()]);
            st.push(i);
        }

        return Arrays.stream(result).max().getAsInt();
    }
}

