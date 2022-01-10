interface Member {
    void callBack();
}

class Customer implements Member {
    public String name;

    public Customer(String name) {
        this.name = name;
    }

    public void callBack() {
        System.out.println("Mr./Miss. " + name + " you are invited for a sale!");
    }
}

class Store {
    public Member[] mem;
    public int count, maxCount;

    public Store(int maxCount) {
        this.maxCount = maxCount;
        count = 0;
        mem = new Member[maxCount];
    }

    public void registerMember(Member m) {
        if (count == maxCount) {
            System.out.println("Sorry, no spots available");
            return;
        }

        mem[count] = m;
        ++count;
    }

    public void inviteToSale() {
        for (int i = 0; i < count; ++i) {
            mem[i].callBack();
        }
    }
}

public class Challenge1 {

    public static void main(String[] args) {
        Member m1 = new Customer("Lakshya Bang");
        Member m2 = new Customer("Bala Kumar");
        Member m3 = new Customer("Bilal Khan");
        Member m4 = new Customer("Abdul Karim Khan");

        Store s = new Store(100);

        s.registerMember(m1);
        s.registerMember(m2);
        s.registerMember(m3);
        s.registerMember(m4);

        s.inviteToSale();
    }
}
