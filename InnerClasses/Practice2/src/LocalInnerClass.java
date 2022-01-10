class Outer {
    public int x = 10;

    void display() {
        class Inner {
            public final int y = 20;
            void display() {
                System.out.println("Hello from Inner class " + x + " " + y);
            }
        }

        Inner i = new Inner();

        i.display();
    }
}

public class LocalInnerClass {
    public static void main(String[] args) {
        Outer o = new Outer();

        o.display();
    }
}
