import java.util.Arrays;

class Allocator {
    private final int[] filledSpaces;
    private final int n;

    public Allocator(int n) {
        filledSpaces = new int[n];
        this.n = n;

        Arrays.fill(filledSpaces, -1);
    }

    public int allocate(int size, int mID) {
        int startIndex = -1;

        for (int i = 0; i < n; ++i) {
            startIndex = i;
            int cnt = 0;
            while (i < n && filledSpaces[i] == -1 && cnt < size) {
                ++i;
                ++cnt;
            }
            if (cnt == size) {
                break;
            }
            else startIndex = -1;
        }

        if (startIndex == -1) return -1;

        for (int i = startIndex; i < startIndex + size; ++i) {
            filledSpaces[i] = mID;
        }

        return startIndex;
    }

    public int free(int mID) {
        int ans = 0;

        for (int i = 0; i < n; ++i) {
            if (filledSpaces[i] == mID) {
                filledSpaces[i] = -1;
                ++ans;
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Allocator loc = new Allocator(10);
        // Initialize a memory array of size 10. All memory units are initially free.

        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 0. The memory array becomes [1,_,_,_,_,_,_,_,_,_]. We return 0.
        System.out.println(loc.allocate(1, 2)); // The leftmost block's first index is 1. The memory array becomes [1,2,_,_,_,_,_,_,_,_]. We return 1.
        System.out.println(loc.allocate(1, 3)); // The leftmost block's first index is 2. The memory array becomes [1,2,3,_,_,_,_,_,_,_]. We return 2.
        System.out.println(loc.free(2)); // Free all memory units with mID 2. The memory array becomes [1,_, 3,_,_,_,_,_,_,_]. We return 1 since there is only 1 unit with mID 2.
        System.out.println(loc.allocate(3, 4)); // The leftmost block's first index is 3. The memory array becomes [1,_,3,4,4,4,_,_,_,_]. We return 3.
        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 1. The memory array becomes [1,1,3,4,4,4,_,_,_,_]. We return 1.
        System.out.println(loc.allocate(1, 1)); // The leftmost block's first index is 6. The memory array becomes [1,1,3,4,4,4,1,_,_,_]. We return 6.
        System.out.println(loc.free(1)); // Free all memory units with mID 1. The memory array becomes [_,_,3,4,4,4,_,_,_,_]. We return 3 since there are 3 units with mID 1.
        System.out.println(loc.allocate(10, 2)); // We can not find any free block with 10 consecutive free memory units, so we return -1.
        System.out.println(loc.free(7)); // Free all memory units with mID 7. The memory array remains the same since there is no memory unit with mID 7. We return 0.
    }
}
