package top.atstudy.basic.designmode.bridge;

public abstract class AbstractPhone {

    private Brand brand;

    public AbstractPhone(Brand brand) {
        this.brand = brand;
    }

    public void brand(){
        this.brand.brand();
    }

}
