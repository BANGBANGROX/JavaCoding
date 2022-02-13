// { Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while(testcases-- > 0){
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int N = Integer.parseInt(element[0]);
            int M = Integer.parseInt(element[1]);
            int arr [][] = new int[N][M];

            for(int i = 0;i<N;i++){
                line = br.readLine();
                String[] elements = line.trim().split("\\s+");
                for(int j = 0; j< M; j++){
                    arr[i][j] = Integer.parseInt(elements[j]);
                }
            }

            Complete obj = new Complete();
            int ans = obj.maximumSum(N, M, arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Complete{


    // Function for finding maximum and value pair
    public static int maximumSum (int n, int m, int arr[][]) {
        //Complete the function
        int ans = 0;
        int lastMaximum = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; --i) {
            int currentMaximum = Integer.MIN_VALUE;
            for (int j = 0; j < m; ++j) {
                if (currentMaximum < arr[i][j] && arr[i][j] < lastMaximum) {
                    currentMaximum = arr[i][j];
                }
            }
            if (currentMaximum == Integer.MIN_VALUE) return 0;
            ans += currentMaximum;
            lastMaximum = currentMaximum;
        }

        return ans;
    }

}





