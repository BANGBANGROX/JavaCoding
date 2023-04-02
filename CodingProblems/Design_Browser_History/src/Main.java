import java.util.ArrayList;

class BrowserHistory {
    private final ArrayList<String> history = new ArrayList<>();
    private int currentIndex;

    public BrowserHistory(String homepage) {
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        ++currentIndex;
        history.add(currentIndex, url);

        int idx = currentIndex + 1;

        while (idx < history.size()) {
            history.remove(idx);
        }
    }

    public String back(int steps) {
        currentIndex = Math.max(currentIndex - steps, 0);

        return history.get(currentIndex);
    }

    public String forward(int steps) {
        currentIndex = Math.min(currentIndex + steps, history.size() - 1);

        return history.get(currentIndex);
    }
}


public class Main {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("noob.com");
        browserHistory.visit("nobita.com");
        browserHistory.visit("shizuka.com");
        browserHistory.visit("suniyo.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(3));
    }
}
