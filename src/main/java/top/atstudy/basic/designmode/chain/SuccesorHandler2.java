package top.atstudy.basic.designmode.chain;

public class SuccesorHandler2 extends AbstractHandler {

    public SuccesorHandler2(AbstractHandler handler) {
        super(handler);
    }

    @Override
    public void handleRequest() {

        if(getHandler() != null){
            getHandler().handleRequest();
        }

        System.out.println(this.getClass().getName());
    }
}
