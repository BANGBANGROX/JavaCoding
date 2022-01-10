class Account {
    private String accNo, name, address, phoneNo, dob;
    private double balance;

    public Account() {
       accNo = "";
       name = "";
       balance = 0;
    }

    public Account (String accNo, String name, String address, String phoneNo, String dob) {
        this.accNo = accNo;
        this.name = name;
        setAddress(address);
        setDob(dob);
        setPhoneNo(phoneNo);
    }

    public String getAccNo() {
        return accNo;
    }

    public String getAddress() {
       return address;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getDob() {
        return dob;
    }

    public double getBalance() {
        return balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setBalance (double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends Account {
     public void deposit (int amt) {
          double currBalance = getBalance();

          currBalance += amt;

          setBalance(currBalance);
     }

     public void withdraw(int amt) {
         double currBalance = getBalance();

         if (currBalance < amt) {
             System.out.println("Not enough balance sorry :(");
         }

         currBalance -= amt;

         setBalance(currBalance);
     }
}

class LoanAccount extends Account {
    public void payEMI (int amt) {
        double currBalance = getBalance();

        currBalance -= amt;

        setBalance(currBalance);
    }

    public void repay (int amt) {
        double currBalance = getBalance();

        if (currBalance == amt) currBalance = 0;

        setBalance(currBalance);
    }
}

public class Challenge1Question1 {
    public static void main (String args[]) {
        LoanAccount loanAcc = new LoanAccount();

        loanAcc.setBalance(10000000);

        loanAcc.payEMI(1000);

        System.out.println(loanAcc.getBalance());
    }
}
