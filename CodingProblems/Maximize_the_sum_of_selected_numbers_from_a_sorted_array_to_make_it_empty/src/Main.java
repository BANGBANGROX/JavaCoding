//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


public class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);

            int[] arr = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }
            Arrays.sort(arr);
            Complete obj = new Complete();
            int ans = obj.maximizeSum(arr);
            System.out.println(ans);
        }
    }
}




// } Driver Code Ends


//User function Template for Java



class Complete {
    // Function for finding maximum and value pair
    public int maximizeSum(int[] nums) {
        //Complete the function
        HashMap<Integer, Integer> count = new HashMap<>();
        int maxValue = Integer.MIN_VALUE;
        int ans = 0;

        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        while (maxValue > 0) {
            if (count.get(maxValue) <= 0) continue;
            ans += maxValue * count.get(maxValue);
            if (count.containsKey(maxValue - 1)) {
                count.put(maxValue - 1, count.get(maxValue - 1) - count.get(maxValue));
            }
            --maxValue;
        }

        return ans;
    }
}


