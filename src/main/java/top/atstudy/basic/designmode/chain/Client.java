package top.atstudy.basic.designmode.chain;

public class Client {

    public static void main(String[] args) {

        AbstractHandler handler3 = new SuccessorHandler3(null);
        AbstractHandler handler2 = new SuccesorHandler2(handler3);

        handler2.handleRequest();

        System.out.println(" ==>> ");
    }

}
