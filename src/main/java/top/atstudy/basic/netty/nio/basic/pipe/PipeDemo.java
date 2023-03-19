package top.atstudy.basic.netty.nio.basic.pipe;

import java.io.IOException;
import java.nio.channels.Pipe;

public class PipeDemo {

    public static void main(String[] args) {




    }


    private static void testPipe(){

        try {
            Pipe pipe = Pipe.open();

            Pipe.SinkChannel sink = pipe.sink();


            Pipe.SourceChannel source = pipe.source();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
