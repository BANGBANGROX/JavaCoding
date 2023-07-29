//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG implements Runnable
{
    public static void main(String[] args) {
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());
            while(t-->0){
                int n=Integer.parseInt(in.readLine().trim());
                int[][] a =new int[n][3];
                for(int i=0;i<n;i++){
                    String[] s =in.readLine().trim().split(" ");
                    a[i][0]=Integer.parseInt(s[0]);
                    a[i][1]=Integer.parseInt(s[1]);
                    a[i][2]=Integer.parseInt(s[2]);
                }
                Solution ob=new Solution();
                out.println(ob.maxCoins(n,a));
            }
            out.close();
        }catch(Exception ignored){
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public int maxCoins(int n, int[][] ranges) {
          Arrays.sort(ranges, (a, b) -> a[0] != b[0] ?
                  a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);

          int[] maximumValue = new int[n];
          int answer = 0;

          maximumValue[n - 1] = ranges[n - 1][2];

          for (int i = n - 2; i >= 0; --i) {
              maximumValue[i] = Math.max(maximumValue[i + 1], ranges[i][2]);
          }

          for (int i = 0; i < n; ++i) {
              int l = i + 1;
              int r = n - 1;
              int initialResult = ranges[i][2];
              int value = 0;
              while (l <= r) {
                  int mid = (l + ((r - l) >> 1));
                  if (ranges[mid][0] >= ranges[i][1]) {
                      value = maximumValue[mid];
                      r = mid - 1;
                  }
                  else l = mid + 1;
              }
              initialResult += value;
              answer = Math.max(answer, initialResult);
          }

          return answer;
    }
}