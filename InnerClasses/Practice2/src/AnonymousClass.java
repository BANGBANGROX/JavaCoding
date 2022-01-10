abstract class Inner {
    abstract void display();
}

public class AnonymousClass {
    public static void main(String[] args) {
        Inner i = new Inner() {
            @Override
            void display() {
                System.out.println("Hello from inner class");
            }
        };

        i.display();
    }
}
