import java.util.Date;

class Customer {
    private String custId;
    private static int count = 0;

    public Customer() {
        custId = generateCustId();
    }

    private static String generateCustId() {
        ++count;
        Date d = new Date();
        System.out.println(d);

        return "INOX" + (d.getYear() + 1900) + count;
    }

    public String getCustId() {
        return custId;
    }
}


public class Challenge3 {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();

        System.out.println(c1.getCustId());
        System.out.println(c2.getCustId());
        System.out.println(c3.getCustId());
    }
}
