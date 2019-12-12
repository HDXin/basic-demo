package top.atstudy.basic.designmode.bridge;

public class Client {

    public static void main(String[] args) {

        Brand brand = new AppleBrand();
        AbstractPhone phone = new FoldedPhone(brand);

        phone.brand();

    }

}
