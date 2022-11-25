//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while (T-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] input_line = read.readLine().trim().split("\\s+");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
            for (int an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public int[] leafNodes(int[] nums, int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        st.push(nums[0]);

        for (int i = 1; i < n; ++i) {
            if (nums[i] < st.peek()) st.push(nums[i]);
            else {
                int num = st.peek();
                int size = st.size();
                while (!st.isEmpty() && nums[i] > st.peek()) st.pop();
                st.push(nums[i]);
                if (size > st.size()) ans.add(num);
            }
        }

        ans.add(st.peek());

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); ++i) {
            result[i] = ans.get(i);
        }

        return result;
    }
}