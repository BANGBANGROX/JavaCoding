//{ Driver Code Starts
// Initial Template for Java

import java.util.Scanner;

// Position this line where user code will be pasted.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();

            Solution ob = new Solution();
            ob.printDiamond(n);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public void printDiamond(int n) {
        // Your code here

        // Upper pyramid print
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; ++k) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }

        // Lower pyramid print
        for (int i = n - 1; i > 0; --i) {
            for (int j = 0; j < n - i; ++j) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; ++k) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
