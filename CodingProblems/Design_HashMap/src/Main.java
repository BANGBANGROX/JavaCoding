import java.util.Arrays;
import java.util.Scanner;

class MyHashMap {
    private int[] map;
    private final int MAX_SIZE = (int)1e6 + 5;

    public MyHashMap() {
       map = new int[MAX_SIZE];
       Arrays.fill(map, -1);
    }

    public void put(int key, int value) {
       map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
