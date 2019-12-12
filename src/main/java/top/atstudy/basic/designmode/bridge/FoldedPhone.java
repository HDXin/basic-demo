package top.atstudy.basic.designmode.bridge;

public class FoldedPhone extends AbstractPhone {

    public FoldedPhone(Brand brand) {
        super(brand);
    }

    public void brand(){
        super.brand();

        System.out.println("折叠式手机");
    }

}
