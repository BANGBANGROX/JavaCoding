class Product {
    private String itemNo, name;
    private double price;
    private int qty;

    public Product(String itemNo, String name, double price, int qty) {
       this.itemNo = itemNo;
       this.name = name;
       setPrice(price);
       setQty(qty);
    }

    public String getItemNo() {
        return itemNo;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty (int qty) {
        this.qty = qty;
    }

    public String toString() {
        return "Item No = " + itemNo + "\nName = " + name + "\nPrice = " + price + "\nQuantity = " + qty;
    }
}

class Customer {
    private String custId, name, address, phoneNo;

    public Customer (String custId, String name, String address, String phoneNo) {
        this.custId = custId;
        this.name = name;
        setAddress(address);
        setPhoneNo(phoneNo);
    }

    public String getCustId() {
        return custId;
    }

    public String getName() {
        return name;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo (String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String toString() {
        return "ID = " + custId + "\nName = " + name + "\nAddress = " + address + "\nPhone No. = " + phoneNo;
    }
}

public class Challenge5Question1 {

    public static void main (String args[]) {

        Product pro = new Product("A001", "Book", 90.896, 12);

        Customer cust = new Customer("CU001", "Ajit Pal", "Rohtak jila", "+91 925212231");

        System.out.println(pro);

        System.out.println(cust);
    }
}
