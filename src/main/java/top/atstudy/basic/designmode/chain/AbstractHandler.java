package top.atstudy.basic.designmode.chain;

import lombok.Getter;

@Getter
public abstract class AbstractHandler {

    private AbstractHandler handler;

    public AbstractHandler(AbstractHandler handler) {
        this.handler = handler;
    }

    public abstract void handleRequest();

}
