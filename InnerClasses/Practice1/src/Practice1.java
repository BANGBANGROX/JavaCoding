class Outer {
    int x = 10;

    class Inner {
        int y = 20;

        public void innerDisplay() {
            System.out.println("Inner class " + x + " " + y);
        }
    }

    public void outerDisplay() {
        Inner i = new Inner();
        System.out.println("Outer class " + x + " " + i.y);
    }
}

public class Practice1 {
    public static void main(String[] args) {
        Outer o = new Outer();
        Outer.Inner oi = new Outer().new Inner();

        o.outerDisplay();
        oi.innerDisplay();
    }
}
