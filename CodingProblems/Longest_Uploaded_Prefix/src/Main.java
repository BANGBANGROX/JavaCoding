class LUPrefix {
    private final boolean[] visited;
    private int ans;

    public LUPrefix(int n) {
       visited = new boolean[n + 1];
       ans = 1;
    }

    public void upload(int video) {
        visited[video] = true;
    }

    public int longest() {
        if (!visited[1]) return 0;

        while (ans < visited.length && visited[ans]) ++ans;

        return ans - 1;
    }
}

public class Main {
    public static void main(String[] args) {
        LUPrefix luPrefix = new LUPrefix(5);

        luPrefix.upload(3);
        System.out.println(luPrefix.longest());
        luPrefix.upload(4);
        luPrefix.upload(2);
        System.out.println(luPrefix.longest());
        luPrefix.upload(1);
        luPrefix.upload(5);
        System.out.println(luPrefix.longest());
    }
}
