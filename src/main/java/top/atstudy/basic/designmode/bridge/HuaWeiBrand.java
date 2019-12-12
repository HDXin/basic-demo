package top.atstudy.basic.designmode.bridge;

public class HuaWeiBrand extends Brand {

    public HuaWeiBrand() {
        this.brand = "hua wei";
    }

    @Override
    void brand() {
        System.out.println(this.brand);
    }

}
