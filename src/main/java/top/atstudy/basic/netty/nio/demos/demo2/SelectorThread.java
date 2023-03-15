package top.atstudy.basic.netty.nio.demos.demo2;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class SelectorThread implements Runnable{

    private Selector selector;

    public SelectorThread(){
        try {
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void acceptHandler(SelectionKey key){



    }

    public void readHandler(SelectionKey key){



    }

    public void writeHandler(SelectionKey key){



    }

    @Override
    public void run() {

        while (true){
            try {
                int num = selector.select();
                if(num > 0){



                }else if(num == 0){

                    break;
                }else if(num < 0){

                    System.out.println("k");

                }




            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
