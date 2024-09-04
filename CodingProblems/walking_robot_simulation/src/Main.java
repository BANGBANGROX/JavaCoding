import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int answer = 0;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int currentDir = 0;
        int x = 0;
        int y = 0;
        Set<List<Integer>> obstaclesSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstaclesSet.add(List.of(obstacle[0], obstacle[1]));
        }

        for (int command : commands) {
            if (command >= 0) {
                int nextX = x + directions[currentDir][0] * command;
                int nextY = y + directions[currentDir][1] * command;
                System.out.println(nextX + " " + nextY);
                if (nextX == x) {
                    // Moving along the y direction
                    if (y <= nextY) {
                        for (int mid = y + 1; mid <= nextY; ++mid) {
                            if (obstaclesSet.contains(List.of(x, mid))) {
                                nextY = mid - 1;
                                break;
                            }
                        }
                    } else {
                        for (int mid = y - 1; mid >= nextY; --mid) {
                            if (obstaclesSet.contains(List.of(x, mid))) {
                                nextY = mid + 1;
                                break;
                            }
                        }
                    }
                } else {
                    // Moving along the x direction
                    if (x <= nextX) {
                        for (int mid = x + 1; mid <= nextX; ++mid) {
                            if (obstaclesSet.contains(List.of(mid, y))) {
                                nextX = mid - 1;
                                break;
                            }
                        }
                    } else {
                        for (int mid = x - 1; mid >= nextX; --mid) {
                            if (obstaclesSet.contains(List.of(mid, y))) {
                                nextX = mid + 1;
                                break;
                            }
                        }
                    }
                }
                x = nextX;
                y = nextY;
                int distanceSquared = x * x + y * y;
                answer = Math.max(answer, distanceSquared);
            } else {
                if (currentDir == 0) {
                    // 0 -> north
                    // 1 -> south
                    // 2 -> west
                    // 3 -> east
                    // Logic
                    // 1. north + left = west
                    // 2. north + right = east
                    // 3. south + left = east
                    // 4. south + right = west
                    // 5. east + left = north
                    // 6. east + right = south
                    // 7. west + left = south
                    // 8. west + right = north
                    if (command == -2) {
                        currentDir = 2;
                    } else {
                        currentDir = 3;
                    }
                } else if (currentDir == 1) {
                    if (command == -2) {
                        currentDir = 3;
                    } else {
                        currentDir = 2;
                    }
                } else if (currentDir == 2) {
                    if (command == -2) {
                        currentDir = 1;
                    } else {
                        currentDir = 0;
                    }
                } else {
                    if (command == -2) {
                        currentDir = 0;
                    } else {
                        currentDir = 1;
                    }
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int n = scanner.nextInt();
           int[] commands = new int[n];
           for (int i = 0; i < n; ++i) {
               commands[i] = scanner.nextInt();
           }
           int m = scanner.nextInt();
           int[][] obstacles = new int[m][2];
           for (int i = 0; i < m; ++i) {
               obstacles[i][0] = scanner.nextInt();
               obstacles[i][1] = scanner.nextInt();
           }

           System.out.println(new Solution().robotSim(commands, obstacles));
       }
       
       scanner.close();
   }
}
