import java.util.Date;

class Account {
    private String accNo;
    private static int count = 0;

    public Account() {
        accNo = generateAccNo();
    }

    private static String generateAccNo() {
        ++count;
        Date d = new Date();

        return "BOB" + (d.getYear() + 1900) + count;
    }

    public String getAccNo() {
        return accNo;
    }
}


public class Challenge2 {
    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();

        System.out.println(a1.getAccNo() + "\n" + a2.getAccNo() + "\n" + a3.getAccNo());
    }
}
