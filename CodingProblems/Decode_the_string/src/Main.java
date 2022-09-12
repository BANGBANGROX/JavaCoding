//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.decodedString(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public String decodedString(String s) {
        // code here
        Stack<Character> st = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (ch != ']') st.push(ch);
            else {
                StringBuilder current = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    current.append(st.pop());
                }
                st.pop();
                current.reverse();
                StringBuilder stringNum = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    stringNum.append(st.pop());
                }
                stringNum.reverse();
                int num = Integer.parseInt(stringNum.toString());
                StringBuilder next = new StringBuilder();
                while (num > 0) {
                    next.append(current);
                    --num;
                }
                for (char c: next.toString().toCharArray()) {
                    st.push(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        return ans.toString();
    }
}