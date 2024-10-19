//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public String roundToNearest(String str) {
        // Complete the function
        int n = str.length();
        char[] strArray = str.toCharArray();
        int remainder = (strArray[n - 1] - '0');

        if (remainder == 0) {
            return str;
        }

        if (remainder <= 5) {
            strArray[n - 1] = '0';
            return new String(strArray);
        }

        int carry = 10 - remainder;

        for (int i = n - 1; i >= 0; --i) {
            int val = strArray[i] + carry - '0';
            strArray[i] = (char) (val % 10 + '0');
            carry = val / 10;
        }

        if (carry > 0) {
            return carry + new String(strArray);
        }
        return new String(strArray);
    }
}


//{ Driver Code Starts.

// Driver class
public class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends