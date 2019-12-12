package top.atstudy.basic.designmode.bridge;

public class AppleBrand extends Brand{

    public AppleBrand() {
        this.brand = "apple";
    }

    @Override
    void brand() {
        System.out.println(this.brand);
    }

}
