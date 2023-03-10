package top.atstudy.basic.jvm.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/12 20:01
 * java 堆溢出，
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 */
public class HeapOOM {


    public static void main(String[] args) throws InterruptedException {

        List<OomObject> oomObjectList = new ArrayList<>();

        int i = 0;
        while (true) {
            TimeUnit.MILLISECONDS.sleep(200);
            OomObject obj = new OomObject();
            oomObjectList.add(new OomObject());
            System.out.println(" ==>> " + i++);
//            System.gc();
        }

    }

    static class OomObject {
        private byte[] b = new byte[1024 * 100];
    }


}
