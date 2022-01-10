class Customer {
    private String name, phoneNo;

    public Customer() {
        name = "";
        phoneNo = "";
    }

    public Customer (String name, String phoneNo) {
        this.name = name;
        setPhoneNo(phoneNo);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void payBill() {
        System.out.println("Bill paid!");
    }
}

class Member extends Customer {
    private String custId, address, dob;

    public Member() {
        custId = "";
        address = "";
        dob = "";
    }

    public Member (String custId, String address, String dob) {
       this.custId = custId;
       setAddress(address);
       this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public String getCustId() {
        return custId;
    }

    public String getDob() {
        return dob;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public void callBack (String today) {
        if (today.matches(getDob())) {
            System.out.println("Happy Birthday!");
        }
    }
}

public class Challenge1Question3 {
    public static void main (String args[]) {
        Member m = new Member("101", "Raipur", "23/11");

        m.callBack("23/11");
    }

}
