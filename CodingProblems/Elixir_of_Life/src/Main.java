//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();

            Sol obj = new Sol();
            System.out.println(obj.maxFrequency(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol {
    int maxFrequency(String s) {
        //code here.
        int n = s.length();
        String result = "";

        for (int i = 1; i < n; ++i) {
            if (s.substring(0, i).equals(s.substring(n - i, n))) {
                result = s.substring(0, i);
                break;
            }
        }

        if (result.isEmpty()) return 1;

        int ans = 0;

        for (int i = 0; i <= n - result.length(); ++i) {
            if (result.equals(s.substring(i, i + result.length()))) {
                ++ans;
            }
        }

        return ans;
    }
}