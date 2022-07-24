package top.atstudy.basic.designmode.chain;

public class SuccessorHandler3 extends AbstractHandler {

    public SuccessorHandler3(AbstractHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest() {

        if (getHandler() != null) {
            getHandler().handleRequest();
        }

        System.out.println(this.getClass().getName());
    }
}
