//{ Driver Code Starts

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the remaining newline

        for (int k = 0; k < t; k++) {
            List<Integer> arr1 = new ArrayList<>();
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            Solution ob = new Solution();
            int ans = ob.maxPathSum(arr1, arr2);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends



class Solution {
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int m = arr1.size();
        int n = arr2.size();
        int firstSum = 0;
        int secondSum = 0;
        int i = 0;
        int j = 0;
        int answer = 0;

        while (i < m && j < n) {
            if (arr1.get(i) < arr2.get(j)) {
                firstSum += arr1.get(i);
                ++i;
            } else if (arr1.get(i) > arr2.get(j)) {
                secondSum += arr2.get(j);
                ++j;
            } else {
                answer += (arr1.get(i) + Math.max(firstSum, secondSum));
                firstSum = secondSum = 0;
                ++i;
                ++j;
            }
        }

        while (i < m) {
            firstSum += arr1.get(i);
            ++i;
        }

        while (j < n) {
            secondSum += arr2.get(j);
            ++j;
        }

        return answer + Math.max(firstSum, secondSum);
    }
}