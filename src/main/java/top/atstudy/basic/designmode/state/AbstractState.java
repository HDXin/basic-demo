package top.atstudy.basic.designmode.state;

public abstract class AbstractState implements State {

    protected InvoiceApplyStateEnum stateEnum;

    public abstract void operation();

    public abstract void operation2();

    public abstract void operation3();

}
