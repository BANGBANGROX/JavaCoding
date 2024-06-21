//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private String getFraction(String[] fraction) {
        return fraction[0] + "/" + fraction[1];
    }

    String compareFrac(String str) {
        // Code here
        String[] fractions = str.split(",");
        String[] fraction1 = fractions[0].trim().split("/");
        String[] fraction2 = fractions[1].trim().split("/");
        int finalNumerator1 = Integer.parseInt(fraction1[0]) * Integer.parseInt(fraction2[1]);
        int finalNumerator2 = Integer.parseInt(fraction2[0]) * Integer.parseInt(fraction1[1]);

        if (finalNumerator1 > finalNumerator2) {
            return getFraction(fraction1);
        } else if (finalNumerator2 > finalNumerator1) {
            return getFraction(fraction2);
        } else {
            return "equal";
        }
    }
}
