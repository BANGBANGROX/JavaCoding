//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String s;
            s = in.readLine().trim();

            Solution ob = new Solution();

            out.println(ob.reverseEqn(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public String reverseEqn(String s) {
        // your code here
        ArrayList<String> operations = new ArrayList<>();
        ArrayList<String> numbers = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder currentNumber = new StringBuilder();
                while (i < n && Character.isDigit(s.charAt(i))) {
                    currentNumber.append(s.charAt(i));
                    ++i;
                }
                numbers.add(currentNumber.toString());
                --i;
            } else operations.add("" + s.charAt(i));
        }

        Collections.reverse(numbers);
        Collections.reverse(operations);

        int ptr1 = 1;
        int ptr2 = 0;
        int len = numbers.size();

        answer.append(numbers.get(0));

        while (ptr1 < len) {
            answer.append(operations.get(ptr2));
            answer.append(numbers.get(ptr1));
            ++ptr1;
            ++ptr2;
        }

        return answer.toString();
    }
}