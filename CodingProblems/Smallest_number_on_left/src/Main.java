//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] a1 = in.readLine().trim().split("\\s+");
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans;
            ans = ob.leftSmaller(n, a);
            for (int i = 0; i < n; i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public List<Integer> leftSmaller(int n, int[] nums) {
        //code here
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            if (st.isEmpty()) ans.add(-1);
            else ans.add(st.peek());
            st.push(i);
        }

        return ans;
    }
}