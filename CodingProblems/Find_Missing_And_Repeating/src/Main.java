// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int[] ans = new int[2];

        for (int i = 0; i < n; ++i) {
            if (arr[Math.abs(arr[i]) - 1] > 0) arr[Math.abs(arr[i]) - 1] *= -1;
            else ans[0] = Math.abs(arr[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (arr[i] > 0) ans[1] = i + 1;
        }

        return ans;
    }
}