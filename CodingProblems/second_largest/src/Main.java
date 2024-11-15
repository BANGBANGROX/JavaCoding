//{ Driver Code Starts
// Initial Template for Java

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int maxElement = Integer.MIN_VALUE;
        int secondMaxElement = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > maxElement) {
                secondMaxElement = maxElement;
                maxElement = num;
            } else if (num > secondMaxElement && num != maxElement) {
                secondMaxElement = num;
            }
        }

        return (secondMaxElement != maxElement && secondMaxElement != Integer.MIN_VALUE) ?
                secondMaxElement : -1;
    }
}