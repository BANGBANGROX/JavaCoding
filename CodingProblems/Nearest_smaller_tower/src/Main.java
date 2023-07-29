//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(str[i]);
            Solution ob = new Solution();
            int[] ans = ob.nearestSmallestTower(arr);
            for (int i = 0; i < n; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }

    }
}
// } Driver Code Ends


// User function Template for Java


class Solution {
    int[] nearestSmallestTower(int[] nums) {
        // Write your code here
        int n = nums.length;
        int[] answer = new int[n];
        int[] rightSmallerIndex = new int[n];
        int[] leftSmallerIndex = new int[n];
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] >= nums[i]) {
                indexStack.pop();
            }
            leftSmallerIndex[i] = indexStack.isEmpty() ? -1 : indexStack.peek();
            indexStack.push(i);
        }

        indexStack.clear();

        for (int i = n - 1; i >= 0; --i) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] >= nums[i]) {
                indexStack.pop();
            }
            rightSmallerIndex[i] = indexStack.isEmpty() ? -1 : indexStack.peek();
            indexStack.push(i);
        }

        for (int i = 0; i < n; ++i) {
            int leftIndex = leftSmallerIndex[i];
            int rightIndex = rightSmallerIndex[i];
            if (leftIndex == -1) {
                answer[i] = rightIndex;
            } else if (rightIndex == -1) {
                answer[i] = leftIndex;
            } else {
                int leftDistance = i - leftIndex;
                int rightDistance = rightIndex - i;
                if (leftDistance < rightDistance) {
                    answer[i] = leftIndex;
                } else if (leftDistance > rightDistance) {
                    answer[i] = rightIndex;
                } else {
                    if (nums[leftIndex] < nums[rightIndex]) {
                        answer[i] = leftIndex;
                    } else if (nums[leftIndex] > nums[rightIndex]) {
                        answer[i] = rightIndex;
                    } else {
                        answer[i] = leftIndex;
                    }
                }
            }
        }

        return answer;
    }
}