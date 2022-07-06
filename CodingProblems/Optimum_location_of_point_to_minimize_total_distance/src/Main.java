// { Driver Code Starts
import java.io.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int[] line = IntArray.input(br, 3);


            int n;
            n = Integer.parseInt(br.readLine());


            int[][] points = IntMatrix.input(br, n);

            Solution obj = new Solution();
            double res = obj.findOptimumCost(line, points);

            System.out.printf("%.3f%n", res);

        }
    }
}
// } Driver Code Ends


class Solution {
    private double getY(double x, int[] line) {
        return -1.0 * (line[2] + line[0] * x) / line[1];
    }
    
    private double getDistance(int[][] points, double x1, double y1) {
        double res = 0;
        
        for (int[] point : points) {
            double x2 = point[0];
            double y2 = point[1];
            res += Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }

        return res;
    }
    
    public double findOptimumCost(int[] line, int[][] points) {
        // code here
        double l = -1000;
        double r = 1000;
        double ans = Integer.MAX_VALUE;

        while ((r - l) >= 0.00001) {
            double midX = (l + r) / 2;
            double midY = getY(midX, line);
            double distance = getDistance(points, midX, midY);
            ans = Math.min(ans, distance);
            double newMidX = midX + 0.001;
            double newMidY = getY(newMidX, line);
            double newDistance = getDistance(points, newMidX, newMidY);
            if (newDistance > distance) r = midX;
            else l = midX;
        }

        return ans;
    }
}

