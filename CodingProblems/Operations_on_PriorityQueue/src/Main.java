//{ Driver Code Starts
//Initial Template for Java

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;


// } Driver Code Ends
//User function Template for Java

// Helper class Geeks to implement 
// insert() and findFrequency()
class Geeks {
    private final HashMap<Integer, Integer> count = new HashMap<>();

    // Function to insert element into the queue
    public void insert(PriorityQueue<Integer> q, int k) {

        // Your code here
        //Just insert k in q and don't return anything
        q.add(k);
        count.put(k, count.getOrDefault(k, 0) + 1);
    }

    // Function to find an element k
    public boolean find(PriorityQueue<Integer> q, int k) {

        // Your code here
        // If k is in q return true else return false
        assert q.peek() != null;

        return count.get(k) != null;
    }

    // Function to delete the max element from queue
    public int delete(PriorityQueue<Integer> q) {

        // Your code here
        //Delete the max element from q. The priority queue property might be useful here
        if (q.isEmpty()) return -1;

        assert q.peek() != null;
        int maxValue = q.poll();

        count.put(maxValue, count.get(maxValue) - 1);

        if (count.get(maxValue) == 0) count.remove(maxValue);

        return maxValue;
    }

}

//{ Driver Code Starts.

// Driver class with driver code
public class Main {

    // Driver code
    public static void main(String[] args) {

        // Taking input using scanner class
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();

        while (testcase-- > 0) {

            // Priority Queue with comparator
            PriorityQueue<Integer> p_queue = new PriorityQueue<>(Comparator.reverseOrder());

            int n = sc.nextInt();

            // Invoking object of Geeks class
            Geeks obj = new Geeks();

            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                obj.insert(p_queue, k);
            }

            //Taking total number queries
            int x = sc.nextInt();

            //if the element entered is present
            //int the PriorityQueue then we print
            //"1" and delete the maximum element
            //else we print "-1"
            for (int i = 0; i < x; i++) {
                int k = sc.nextInt();
                boolean f = obj.find(p_queue, k);
                if (f) {
                    System.out.println("1");
                    System.out.println(obj.delete(p_queue));
                } else {
                    System.out.println("-1");
                }
            }
        }
    }
}
// } Driver Code Ends