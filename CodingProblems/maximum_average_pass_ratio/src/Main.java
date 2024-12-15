import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution {
    private static class Class {
        int passingStudents;
        int totalStudents;

        Class(int passingStudents, int totalStudents) {
            this.passingStudents = passingStudents;
            this.totalStudents = totalStudents;
        }
    }

    private static double getValue(Class a) {
        return 1.0 * (a.passingStudents + 1) / (a.totalStudents + 1) -
                1.0 * a.passingStudents / a.totalStudents;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Class> pq = new PriorityQueue<>(Comparator.comparingDouble(a ->
                -1 * getValue(a)));
        double totalSum = 0;

        for (int[] currentClass : classes) {
            pq.add(new Class(currentClass[0], currentClass[1]));
        }

        for (int i = 0; i < extraStudents && !pq.isEmpty(); ++i) {
            Class top = pq.poll();
            ++top.totalStudents;
            ++top.passingStudents;
            pq.add(top);
        }

        while (!pq.isEmpty()) {
            Class top = pq.poll();
            totalSum += 1.0 * (top.passingStudents) / top.totalStudents;
        }

        return totalSum / classes.length;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[][] classes = new int[n][2];
           for (int i = 0; i < n; ++i) {
               classes[i][0] = scanner.nextInt();
               classes[i][1] = scanner.nextInt();
           }
           int extraStudents = scanner.nextInt();

           System.out.println(new Solution().maxAverageRatio(classes, extraStudents));
       }
       
       scanner.close();
   }
}
