//{ Driver Code Starts

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();

            System.out.println(new Solution().carpetBox(A, B, C, D));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int carpetBox(int carpetHeight, int carpetWidth, int boxHeight, int boxWidth) {
        //code here
        int ans = 0;
        int l1 = Math.max(carpetHeight, carpetWidth);
        int b1 = Math.min(carpetHeight, carpetWidth);
        int l = Math.max(boxHeight, boxWidth);
        int b = Math.min(boxHeight, boxWidth);

        while (l1 > l || b1 > b) {
            if (l1 > l && b1 > b) {
                l1 /= 2;
            }
            else if (l1 > l) {
                l1 /= 2;
            }
            else b1 /= 2;
            int x = l1;
            int y = b1;
            l1 = Math.max(x, y);
            b1 = Math.min(x, y);
            ++ans;
        }

        return ans;
    }
}
