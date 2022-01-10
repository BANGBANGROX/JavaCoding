class OuterStatic {
    static int x = 10;
    //int y = 20;

    static class Inner {
        void display() {
            System.out.println("Hello from inner class " + x);
        }
    }
}

public class StaticInnerClass {
    public static void main(String[] args) {
        OuterStatic.Inner oi = new OuterStatic.Inner();

        oi.display();
    }
}
