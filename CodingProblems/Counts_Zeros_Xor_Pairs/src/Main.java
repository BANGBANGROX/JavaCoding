// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


public class Main {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);

            int[] arr = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for(int i = 0;i<sizeOfArray;i++){
                arr[i] = Integer.parseInt(elements[i]);
            }


            Complete obj = new Complete();
            long res = obj.calculate(arr);
            System.out.println(res);
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Complete {
    // Function for finding maximum and value pair
    public long calculate (int[] nums) {
        // Complete the function
        long ans = 0;
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int key : count.keySet()) {
            int cnt = count.get(key);
            ans += (long)cnt * (cnt - 1) / 2;
        }

        return ans;
    }
}


