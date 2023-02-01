//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.removePair(s);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public String removePair(String s) {
        // code here
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == ch) st.pop();
            else st.push(ch);
        }

        if (st.isEmpty()) return "-1";

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}

