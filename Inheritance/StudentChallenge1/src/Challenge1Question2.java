class CellPhone {
    private String phoneNo, imei;

    public CellPhone() {
        phoneNo = "";
        imei = "";
    }

    public CellPhone (String phoneNo, String imei) {
        this.phoneNo = phoneNo;
        this.imei = imei;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getImei() {
        return imei;
    }

    public void call() {
        System.out.println("You are on a call!");
    }

    public void sendSMS() {
        System.out.println("Sending sms...");
    }
}

class SmartPhone extends CellPhone {
    String mac;

    public SmartPhone() {
        mac = "";
    }

    public SmartPhone(String mac) {
        this.mac = mac;
    }

    public String getMac() {
        return mac;
    }

    public void play() {
        System.out.println("Playing a video!");
    }

    public void capture() {
        System.out.println("Capturing a photo...");
    }
}

public class Challenge1Question2 {
    public static void main (String args[]) {
        SmartPhone smp = new SmartPhone();

        smp.capture();
        smp.call();
        smp.play();
    }
}
